package com.epam.ErrorUniversity;

import java.util.List;

public class Group extends Student{

    String groupName;

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    /*Нахождение среднего бала в группе*/
    public void averageMarkInGroup(List<Student> studentList, String checkedGroupName,
                                     SubjectOfStudy checkedSubjectOfStudy, Faculty facultyName) throws UniversityException {
        int quantityOfEligibleStudents = 0;
        int quantittuOfStudentsInCheckedGroup = 0;
        double summaryMarkInGroupBySubject = 0;
        for (Student student : studentList) {
            if (student.group.groupName.equalsIgnoreCase(checkedGroupName) && student.faculty.equals(facultyName)){
                summaryMarkInGroupBySubject += Integer.parseInt(student.ratingStudent.get(checkedSubjectOfStudy).toString());
                quantityOfEligibleStudents++;
            }
            if(student.group.groupName.equalsIgnoreCase(checkedGroupName)){
                quantittuOfStudentsInCheckedGroup++;
            }
        }
        if (quantittuOfStudentsInCheckedGroup == 0){
            throw new UniversityException("В проверяемой группе отсутствуют студенты");
        }
        System.out.println("Средний балл в группе " + checkedGroupName + " факультета " + facultyName.getFacultyName() +
                " по предмету " + checkedSubjectOfStudy.subjectName +
                " равен "  + (summaryMarkInGroupBySubject / quantityOfEligibleStudents));
    }



}
