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
                "�鼮id=" + bid +
                ", �鼮����='" + title + '\'' +
                ", �鼮����='" + desc + '\'' +
                ", �鼮��Ǯ=" + price +
                '}';
    }

    public book() {
    }
}
