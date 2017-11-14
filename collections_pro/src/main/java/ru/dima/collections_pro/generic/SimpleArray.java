package ru.dima.collections_pro.generic;

import java.util.Iterator;

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
     * @return
     */
    public int getSize() {
        return objects.length;
    }

    /**
     * @param value
     */
    public void add(T value) {
        if (index == objects.length - 1) {
            Object[] tmp = objects;
            objects = new Object[objects.length * 2];
            System.arraycopy(tmp, 0, objects, 0, tmp.length);
        } else {
            this.objects[index++] = value;
        }
    }

    /**
     * @param position
     * @return
     */
    public T get(int position) {
        if (position >= 0 && position < objects.length) {
            return (T) this.objects[position];
        } else return null;
    }


    /**
     * @param position
     * @return
     */
    public boolean delete(int position) {
        if (position >= 0 && position < objects.length) {
            this.objects[position] = null;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param position
     * @param value
     * @return
     */
    public boolean update(int position, T value) {
        if (position >= 0 && position < objects.length) {
            this.objects[position] = value;
            return true;
        } else {
            return false;
        }
    }
}
