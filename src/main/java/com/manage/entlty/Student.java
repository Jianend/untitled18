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
            this.sex="��";
        }else {
            this.sex="Ů";
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", ѧ������='" + name + '\'' +
                ", ѧ���Ա�='" + sex + '\'' +
                ", ѧ���꼶=" + grade +
                '}';
    }

    public Student() {
    }
}
