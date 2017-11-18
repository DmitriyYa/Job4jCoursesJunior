package ru.dima.collections_pro.list;

public class SimpleStack<T> {

    /**
     * Контейнер.
     */
    private LinkedList<T> linkedList;

    /**
     * Конструктор по умалчянию.
     */
    public SimpleStack() {
        this.linkedList = new LinkedList<>();
    }

    /**
     * Возвращает и удуляет последний элемент контейнера.
     *
     * @return первый элемент контейнера.
     */
    public T pool() {
        if (linkedList.getSize() <= 0) {
            return null;
        } else {
            T element = linkedList.get(getSize()-1);
            linkedList.removeLast();
            return element;
        }
    }

    /**
     * всдавляет элемент последним в контейнер.
     *
     * @param value элемент.
     */
    public void push(T value) {
        linkedList.addElementLast(value);
    }

    /**
     * @return  размер контейнера.
     */
    public int getSize() {
        return linkedList.getSize();
    }
}
