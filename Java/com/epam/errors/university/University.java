package com.epam.errors.university;

import com.epam.errors.exception.UniversityException;

import java.util.ArrayList;

public class University {

    private ArrayList<Faculty> universityArrayList = new ArrayList<>();

    public void addFacultyInUniversity(Faculty faculties) throws UniversityException {

        if (faculties.groupArrayList.isEmpty() && universityArrayList.size()==0){
            throw new UniversityException("В университете отсутствуют факультеты");
        }

        if (faculties.groupArrayList.isEmpty()){
            throw new UniversityException("Добавляемый факультет пуст");
        }
        universityArrayList.add(faculties);

    }

    public double getAverageMarkBySubjectInUniversity(SubjectOfStudy subjectOfStudy) throws UniversityException {
        double totalMarkBySubjectInUniversity = 0;
        int quantityOfStudentsInUniversity = 0;
        for (int i = 0; i < universityArrayList.size(); i++) {
            totalMarkBySubjectInUniversity += universityArrayList.get(i)
                    .getAverageMarkInTheFacultyBySubject(subjectOfStudy);
            quantityOfStudentsInUniversity ++;
        }
    return totalMarkBySubjectInUniversity/quantityOfStudentsInUniversity;
    }

    @Override
    public String toString() {
        return universityArrayList.toString();
    }
}
