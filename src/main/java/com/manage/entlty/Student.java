package com.manage.entlty;

import lombok.Data;

@Data
public class Student {
    int sid;
    String name;
    String sex;
    int grade;

    public Student(String name, String sex, int grade) {

        this.name = name;
        this.sex = sex;
        this.grade = grade;
    }
}
