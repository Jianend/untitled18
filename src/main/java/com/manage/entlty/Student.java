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
        if (sex.equals("1")){
            this.sex="男";
        }else {
            this.sex="女";
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", 学生名称='" + name + '\'' +
                ", 学生性别='" + sex + '\'' +
                ", 学生年级=" + grade +
                '}';
    }

    public Student() {
    }
}
