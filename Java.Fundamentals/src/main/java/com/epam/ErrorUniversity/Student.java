package com.epam.ErrorUniversity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Student{
    String name;
    int yearOfBirth;
    Group group;
    Faculty faculty;
    HashMap ratingStudent = new HashMap();

    public Student() {
    }

    public Student(String name, int yearOfBirth, Group group, Faculty faculty, HashMap<SubjectOfStudy, Integer> ratingStudent)
            throws UniversityException {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.group = group;
        this.faculty = faculty;
        Iterator<Map.Entry<SubjectOfStudy, Integer>> iterator = ratingStudent.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = iterator.next();
            try {
               if ( Integer.parseInt(entry.getValue().toString()) > 10 ||
                       Integer.parseInt(entry.getValue().toString()) < 0){
                    iterator.remove();
                    throw new UniversityException("У студента " + name
                           + " оценка по предмету " + entry.getKey() + " выше 10 или меньше 0");
                }
            } catch (UniversityException e){
                System.out.println(e);
            }
        }
        if (ratingStudent.isEmpty()){
            throw new UniversityException("У студента " + name + " отсуствуют предметы обучения");
        }
        this.ratingStudent = ratingStudent;
    }

    public double averageMark(){
        this.ratingStudent = ratingStudent;
        Iterator<Map.Entry<SubjectOfStudy, Integer>> iterator = ratingStudent.entrySet().iterator();
        int score = 0;
        int quantityOfSubject = 0;
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            score += Integer.parseInt(entry.getValue().toString());
            quantityOfSubject++;
        }
        return (double) score/quantityOfSubject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", group=" + group +
                ", faculty=" + faculty +
                ", ratingStudent=" + ratingStudent +
                '}';
    }
}
