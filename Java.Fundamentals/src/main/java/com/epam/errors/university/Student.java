package com.epam.errors.university;

import com.epam.errors.exception.UniversityException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Student extends Group{
    HashMap<SubjectOfStudy, Integer> ratingStudent;
    String name;

    public Student(HashMap<SubjectOfStudy, Integer> ratingStudent, String name) throws UniversityException {
        this.ratingStudent = ratingStudent;
        this.name = name;
        if (ratingStudent.isEmpty()){
            throw new UniversityException("У студента " + name + " отсутсвуют предметы обучения");
        }
        Iterator<Map.Entry<SubjectOfStudy, Integer>> iterator = ratingStudent.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<SubjectOfStudy, Integer> entry = iterator.next();
            if (Integer.parseInt(entry.getValue().toString()) > 10 || Integer.parseInt(entry.getValue().toString()) < 0){
                throw new UniversityException("У студента " + name + " оценка по предмету " + entry.getKey().subjectName +
                    " больше 10 или меньше 0");
            }
        }
    }

    public double getAverageMarkStudent() {
        Iterator<Map.Entry<SubjectOfStudy, Integer>> studentIterator = ratingStudent.entrySet().iterator();
        int quantityOfSubject = 0;
        double totalMark = 0;
        while (studentIterator.hasNext()) {
            Map.Entry entry = studentIterator.next();
            totalMark += Integer.parseInt(entry.getValue().toString());
            quantityOfSubject++;
        }
        return totalMark/quantityOfSubject;
    }

    public double getAverageMarkStudentBySubject(SubjectOfStudy subjectOfStudy) throws UniversityException{
        Iterator<Map.Entry<SubjectOfStudy, Integer>> studentIterator = ratingStudent.entrySet().iterator();
        int quantityOfSubject = 0;
        double totalMark = 0;
        while (studentIterator.hasNext()) {
            Map.Entry entry = studentIterator.next();
            if(entry.getKey().equals(subjectOfStudy)){
            totalMark += Integer.parseInt(entry.getValue().toString());
            quantityOfSubject++;
            }
        }
        if (quantityOfSubject == 0){
            throw new UniversityException("Отсутствуют студенты с данным предметом");
        }
        return totalMark/quantityOfSubject;
    }


    @Override
    public String toString() {
        return "Student{" +
                "ratingStudent=" + ratingStudent +
                ", name='" + name + '\'' +
                '}';
    }

    public HashMap<SubjectOfStudy, Integer> getRatingStudent() {
        return ratingStudent;
    }

    public void setRatingStudent(HashMap<SubjectOfStudy, Integer> ratingStudent) {
        this.ratingStudent = ratingStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

