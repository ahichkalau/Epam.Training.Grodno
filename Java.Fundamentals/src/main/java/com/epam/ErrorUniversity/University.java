package com.epam.ErrorUniversity;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class University extends Group {
    public void averageMarkInUniversity(List<Student> studentList,SubjectOfStudy checkedSubjectOfStudy) throws UniversityException {
        int quantityOfEligibleStudents = 0;
        double summaryMarkInUniversityBySubject = 0;

        for (Student student : studentList) {
            Iterator iterator = student.ratingStudent.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry entry =(Map.Entry) iterator.next();
                if (entry.getKey().equals(checkedSubjectOfStudy)){
                    summaryMarkInUniversityBySubject += Integer.parseInt(student.ratingStudent.get(checkedSubjectOfStudy).toString());
                    quantityOfEligibleStudents++;
                }
            }
            if (studentList.isEmpty()){
                throw new UniversityException("В университете отсутствуют студенты))");
            }
        }
        System.out.println("Средний балл университета" +
                " по предмету " + checkedSubjectOfStudy.subjectName +
                " равен "  + (summaryMarkInUniversityBySubject / quantityOfEligibleStudents));
    }

}
