package com.epam.errorUniversitySecondVariant;
/*В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы. У каждого студента есть
несколько учебных предметов по которым он получает оценки. Необходимо реализовать иерархию студентов, групп и факультетов.

        +Посчитать средний балл по всем предметам студента
        +Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
        +Посчитать средний балл по предмету для всего университета
        Релизовать следующие исключения:

        +Оценка ниже 0 или выше 10
        +Отсутсвие предметов у студента (должен быть хотя бы один)
        +Отсутствие студентов в группе
        +Отсутствие групп на факультете
        +Отсутствие факультетов в университете*/
import com.epam.ErrorUniversity.UniversityException;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws UniversityException{

        try {

        Student student1 = new Student(new HashMap<SubjectOfStudy, Integer>(){{put(SubjectOfStudy.HISTORY, 6);
        put(SubjectOfStudy.PHYSICS, 6);}}, "Доронин Сергей Михайлович");

        Student student2 = new Student(new HashMap<SubjectOfStudy, Integer>(){{put(SubjectOfStudy.HISTORY, 6);
        put(SubjectOfStudy.MATH,5);}}, "Блохин Спартак Сергеевич");

        Student student3 = new Student(new HashMap<SubjectOfStudy, Integer>(){{put(SubjectOfStudy.PHYSICS,3 );
        put(SubjectOfStudy.HISTORY,5);}}, "Никитин Ждан Анатолиевич");

        Student student4 = new Student(new HashMap<SubjectOfStudy, Integer>(){{put(SubjectOfStudy.HISTORY, 7);}},
                "Меркушев Карл Андреевич");
        Student student5 = new Student(new HashMap<SubjectOfStudy, Integer>(){{put(SubjectOfStudy.HISTORY, 9);
        put(SubjectOfStudy.MATH,5);}}, "Щербаков Георгий Михайлович");

        Student student6 = new Student(new HashMap<SubjectOfStudy, Integer>(){{put(SubjectOfStudy.PHYSICS, 3);
        put(SubjectOfStudy.HISTORY,5);}}, "Артемьев Харитон Романович");

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
