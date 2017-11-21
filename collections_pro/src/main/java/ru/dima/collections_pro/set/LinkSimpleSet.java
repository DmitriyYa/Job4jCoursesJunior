package ru.dima.collections_pro.set;

import ru.dima.collections_pro.list.LinkedList;

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
public class LinkSimpleSet<E> extends LinkedList {
    /**
     * Контейнер.
     */
    private LinkedList<E> linkedList;

    public LinkSimpleSet() {
        this.linkedList = new LinkedList<E>();
    }


    public void add(E e){
       for (int i=0;i<linkedList.getSize();i++){

       }
    }
}
