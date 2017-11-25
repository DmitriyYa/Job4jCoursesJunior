package ru.dima.collections_pro.map;

import java.util.Calendar;

/**
 * 1. Создать модель User [#999]
 * <p>
 * Создать модель User и три поля String name, int children, Calendar birthday,
 */
public class User {

    public String name;

    public int children;

    public Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
