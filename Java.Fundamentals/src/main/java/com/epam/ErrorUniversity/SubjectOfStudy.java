package com.epam.ErrorUniversity;

public enum SubjectOfStudy{
    MATH("Математика"), PHYSICS("Физика"), RUSSION_LANGUAGE("Русский язык"), HISTORY("История");
    String subjectName;

    SubjectOfStudy(String subjectName) {
        this.subjectName = subjectName;
    }
}
