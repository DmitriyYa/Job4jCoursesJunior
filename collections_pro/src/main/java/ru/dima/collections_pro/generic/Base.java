package ru.dima.collections_pro.generic;

/**
 * где Base - это абстрактный класс для моделей c методами String getId(); void setId(String id).
 */

public abstract class Base {
    private  String id;

    public Base(String id) {
        this.id = id;
    }

    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

}
