package ru.dima.collections_pro.set;

import ru.dima.collections_pro.list.LinkedList;

import java.util.Iterator;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 18.11.17 22:38
 * Copyright © LLP JazzSoft
 * <p>
 * 2. Set реализованный на связном списке. [#997]
 * <p>
 * Реализовать коллекцию SimpleSet.
 * Коллекция должна обеспечивать void add(E e) и реализовывать Iterator<E>.
 * Коллекция не должна хранить дубликаты.
 * Set - внутри для хранения данных использует связный список.
 */
public class LinkSimpleSet<E> implements Iterable<E> {
    /**
     * Контейнер.
     */
    private LinkedList<E> linkedList;

    public LinkSimpleSet() {
        this.linkedList = new LinkedList<E>();
    }


    public void add(E e) {
        if (!thereAreDuplicates(e)) {
            linkedList.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return linkedList.iterator();
    }


    /**
     * @return если есть дубликаты в коллекции, заменить. и вернуть true
     */
    private boolean thereAreDuplicates(E e) {
        boolean result = false;
        for (int i = 0; i < linkedList.getSize(); i++) {
            if (e.equals(linkedList.get(i))) {
                linkedList.remove(linkedList.get(i));
                linkedList.add(e);
                result = true;
            }
        }
        return result;
    }

    /**
     * @param index
     * @return
     */
    public E get(int index) {
        return linkedList.get(index);
    }
}
