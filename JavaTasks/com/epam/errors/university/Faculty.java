package com.epam.errors.university;

import com.epam.errors.exception.UniversityException;

import java.util.ArrayList;

public class Faculty extends University {
    private String facultyName;
    ArrayList<Group> groupArrayList = new ArrayList<>();

    public void addGroupInFaculty(Group group, String facultyName) throws UniversityException {
        groupArrayList.add(group);
        this.facultyName = facultyName;
        if (group.studentArrayList.isEmpty()){
            throw new UniversityException("В добавляемой группе " + group.groupName + " отсутствуют студенты");
        }
    }

    public void addGroupInFaculty(Group group) throws UniversityException{
        groupArrayList.add(group);
        if (group.studentArrayList.isEmpty()){
            throw new UniversityException("В добавляемой группе " + group + " отсутствуют студенты");
        }
    }

    public double getAverageMarkInTheFacultyGroupBySubject(Group group, SubjectOfStudy subjectOfStudy)
            throws UniversityException {
        double totalMarkInGroupBySubject = 0;
        int quantityOfStudentsWithThisSubject = 0;
        for (int i = 0; i < groupArrayList.size(); i++) {
            if (groupArrayList.get(i).equals(group)){
                for (int j = 0; j < groupArrayList.get(i).studentArrayList.size(); j++) {
                    Student checkedStudent = groupArrayList.get(i).studentArrayList.get(j);
                    if (checkedStudent.ratingStudent.containsKey(subjectOfStudy)){
                        totalMarkInGroupBySubject += checkedStudent.getAverageMarkStudentBySubject(subjectOfStudy);
                        quantityOfStudentsWithThisSubject++;
                    }
                }
            }
        }
        if (quantityOfStudentsWithThisSubject == 0){
            throw new UniversityException("Отсутствуют студенты с выбранным предметом " + subjectOfStudy.subjectName);
        }
        return totalMarkInGroupBySubject/quantityOfStudentsWithThisSubject;
    }

    public double getAverageMarkInTheFacultyBySubject(SubjectOfStudy subjectOfStudy) throws UniversityException {
        double totalMarkInFaculty = 0;
        int quantityOfStudentsInFaculty = 0;
        for (int i = 0; i < groupArrayList.size(); i++) {
            Group checkedGroup = groupArrayList.get(i);
            for (int j = 0; j < checkedGroup.studentArrayList.size(); j++) {
                if (checkedGroup.studentArrayList.get(j).ratingStudent.containsKey(subjectOfStudy)){
                    totalMarkInFaculty += groupArrayList.get(i)
                        .studentArrayList.get(j)
                        .getAverageMarkStudentBySubject(subjectOfStudy);
                    quantityOfStudentsInFaculty ++;
                }
            }
        }
        return totalMarkInFaculty/quantityOfStudentsInFaculty;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName='" + facultyName + '\'' +
                ", groupArrayList=" + groupArrayList +
                '}';
    }
}
