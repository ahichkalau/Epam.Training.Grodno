package com.epam.errorUniversitySecondVariant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы. У каждого студента есть
несколько учебных предметов по которым он получает оценки. Необходимо реализовать иерархию студентов, групп и факультетов.

        +Посчитать средний балл по всем предметам студента
        +Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
        +Посчитать средний балл по предмету для всего университета
        Релизовать следующие исключения:

        +Оценка ниже 0 или выше 10
        +Отсутсвие предметов у студента (должен быть хотя бы один)
        +Отсутствие студентов в группе
        Отсутствие групп на факультете
        Отсутствие факультетов в университете*/

public class TESTTT {
    public static void main(String[] args) {
        try {
            Student alex = new Student("Вавилов Гавриил Никонович", 2000, new Group("qw"), Faculty.MILITARY,
                    new HashMap(){{put(SubjectOfStudy.HISTORY, 6);put(SubjectOfStudy.RUSSION_LANGUAGE,7);}});

            Student kolya = new Student("Гачегов Артем Глебович", 1999, new Group("qw"),
                    Faculty.ARTS_DESIGN,new HashMap(){{put(SubjectOfStudy.HISTORY,5);put(SubjectOfStudy.PHYSICS,4);put(SubjectOfStudy.MATH,3);}});

            Student artyom = new Student("Турчанинов Вадим Мартьянович", 1998, new Group("qw"), Faculty.ARTS_DESIGN,
                    new HashMap(){{put(SubjectOfStudy.HISTORY, 4);put(SubjectOfStudy.RUSSION_LANGUAGE,7);}});

            Student vadim = new Student("Черкасов Андриян Аникитевич", 1998, new Group("qw"),
                    Faculty.ARTS_DESIGN,new HashMap(){{put(SubjectOfStudy.HISTORY,5);put(SubjectOfStudy.PHYSICS,5);put(SubjectOfStudy.MATH,4);}});

            Student student5 = new Student("Гринина Кристина Филимоновна", 1999, new Group("qw"), Faculty.ARTS_DESIGN,
                    new HashMap(){{put(SubjectOfStudy.HISTORY, 9);put(SubjectOfStudy.RUSSION_LANGUAGE,5);}});


            List<Student> students = Arrays.asList(alex,kolya,artyom,vadim,student5);
            Group group = new Group();

            group.averageMarkInGroup(students, "qw", SubjectOfStudy.HISTORY,Faculty.ARTS_DESIGN);
            University university = new University();
            university.averageMarkInUniversity(students,SubjectOfStudy.HISTORY);


            System.out.println(vadim.averageMark());

            Student student = new Student();

        } catch (UniversityException e){
            System.out.println(e);
        }
    }
}
