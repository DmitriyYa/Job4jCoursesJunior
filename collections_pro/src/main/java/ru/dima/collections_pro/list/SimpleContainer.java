package ru.dima.collections_pro.list;

public interface SimpleContainer<E> extends Iterable<E> {
    boolean add(E e);

    E get(int index);
}
