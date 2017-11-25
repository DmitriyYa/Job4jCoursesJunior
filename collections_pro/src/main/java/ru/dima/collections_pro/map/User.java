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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User userOne = (User) o;
//
//        if (children != userOne.children) return false;
//        if (name != null ? !name.equals(userOne.name) : userOne.name != null) return false;
//        return birthday != null ? birthday.equals(userOne.birthday) : userOne.birthday == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + children;
//        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
//        return result;
//    }
}
