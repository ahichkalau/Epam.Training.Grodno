package com.epam.errorUniversitySecondVariant;

import com.epam.ErrorUniversity.UniversityException;

import java.util.ArrayList;


public class Group extends Faculty {
    ArrayList<Student> studentArrayList = new ArrayList();
    String groupName;

    public void addStudentInGroup(ArrayList<Student> students, String groupName) throws UniversityException{
        studentArrayList.addAll(students);
        this.groupName = groupName;
        if (studentArrayList.isEmpty()){
            throw new UniversityException("В группе " + groupName + " отсутствуют студенты");
        }
    }
    public void addStudentInGroup(ArrayList<Student> students) throws UniversityException{
        studentArrayList.addAll(students);
        if (studentArrayList.isEmpty()){
            throw new UniversityException("В группе " + groupName + " отсутствуют студенты");
        }
    }

    public void addStudentInGroup(Student student){
        studentArrayList.add(student);
        this.groupName = groupName;
    }



    @Override
    public String toString() {
        return  groupName + studentArrayList.toString();
    }
}
