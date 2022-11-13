package com.manage.entlty;

import lombok.Data;

@Data
public class book {
    int bid;
    String title;
    String desc;
    double price;

    public book(String title, String desc, double price) {
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    @Override
    public String toString() {
        return "book{" +
                "书籍id=" + bid +
                ", 书籍名称='" + title + '\'' +
                ", 书籍介绍='" + desc + '\'' +
                ", 书籍价钱=" + price +
                '}';
    }

    public book() {
    }
}
