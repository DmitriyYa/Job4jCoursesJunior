package ru.dima.collections_pro.generic;

import java.util.ArrayList;

/**
 * Доделать контейнер SimpleArray<T> добавить методы add, update, delete, get(int index);
 *
 * @param <T>
 */
public class SimpleArray<T> {
    private Object[] objects;
    private int index = 0;

    /**
     * @param size
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * @param value
     */
    public void add(T value) {
        this.objects[index++] = value;
    }

    /**
     * @param position
     * @return
     */
    public T get(int position) {
        return (T) this.objects[position];
    }

    /**
     * @param position
     */
    public void delete(int position) {
        this.objects[position] = null;
    }

    /**
     * @param position
     * @param value
     */
    public void update(int position, int value) {
        this.objects[position] = value;
    }
}
