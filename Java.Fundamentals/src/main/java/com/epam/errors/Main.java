package com.epam.errors;

import com.epam.errors.exception.UniversityException;
import com.epam.errors.university.*;

import java.util.ArrayList;
import java.util.HashMap;

import static com.epam.errors.university.SubjectOfStudy.*;

public class Main {
    public static void main(String[] args) throws UniversityException {

        try {

        Student student1 = new Student(new HashMap<SubjectOfStudy, Integer>(){{put(HISTORY, 6);
        put(PHYSICS, 6);}}, "Доронин Сергей Михайлович");

        Student student2 = new Student(new HashMap<SubjectOfStudy, Integer>(){{put(HISTORY, 6);
        put(MATH,5);}}, "Блохин Спартак Сергеевич");

        Student student3 = new Student(new HashMap<SubjectOfStudy, Integer>(){{put(PHYSICS,3 );
        put(HISTORY,5);}}, "Никитин Ждан Анатолиевич");

        Student student4 = new Student(new HashMap<SubjectOfStudy, Integer>(){{put(HISTORY, 7);}},
                "Меркушев Карл Андреевич");
        Student student5 = new Student(new HashMap<SubjectOfStudy, Integer>(){{put(HISTORY, 9);
        put(MATH,5);}}, "Щербаков Георгий Михайлович");

        Student student6 = new Student(new HashMap<SubjectOfStudy, Integer>(){{put(PHYSICS, 3);
        put(HISTORY,5);}}, "Артемьев Харитон Романович");

        Group isit = new Group();
        isit.addStudentInGroup(new ArrayList<>(){{add(student1);add(student2);add(student3);}}, "ТЭЭО");

        Group teeo = new Group();
        teeo.addStudentInGroup(new ArrayList<>(){{add(student4);add(student5);add(student6);}}, "ИСИТ");

        Faculty testFaculty = new Faculty();
        testFaculty.addGroupInFaculty(isit, "ISIT");
        testFaculty.addGroupInFaculty(teeo);

        University testUniversity = new University();
        testUniversity.addFacultyInUniversity(testFaculty);

        System.out.println(testFaculty.getAverageMarkInTheFacultyGroupBySubject(isit, SubjectOfStudy.HISTORY));

        }catch (UniversityException e){
            System.out.println(e);
        }
    }
}
