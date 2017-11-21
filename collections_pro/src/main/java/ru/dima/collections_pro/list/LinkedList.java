package ru.dima.collections_pro.list;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 5.3.2. Создать контейнер на базе связанного списка  [#159]
 * <p>
 * Необходимо создать контейнер с методами
 * <p>
 * add(E value);
 * <p>
 * E get(int index);
 * <p>
 * и реализовать для него Iterable<E>.
 * <p>
 * Внутри контейнера должен данные должны храниться через ссылки.
 * <p>
 * Контейнер должен быть динамический. То есть метод add(E value) - может принимать бесконечное количество элементов.
 * <p>
 * Внутри контейнера нельзя использовать структуры данных из JDK - ArrayList. LinkedList и другие.
 */
public class LinkedList<E> implements SimpleContainer<E> {


    /**
     * размер коллекции.
     */
    private int size=0;

    /**
     * Первый элемент коллекции
     */
    private Node<E> first;

    /**
     * Последний элемент коллекции.
     */
    private Node<E> last;

    /**
     * конструктор по умолчанию.
     */
    public LinkedList() { }

    /**
     * @return размер контейнера.
     */
    public int getSize() {
        return size;
    }

    /**
     * Добавить эалемент в коллекцию.
     *
     * @param e - элемент.
     * @return результат.
     */
    @Override
    public boolean add(E e) {
        addElementLast(e);
        return true;
    }

    /**
     * Добавить элемент в конец списка.
     *
     * @param e элемент.
     */
    void addElementLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    /**
     * Добавить элемент в начало списка.
     *
     * @param e элемент.
     */
    void addElementFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    /**
     * Получить элемент коллекции по индексу.
     *
     * @param index индекс.
     * @return элемент.
     */
    @Override
    public E get(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getElementByIndex(index);
    }

    /**
     * Итератор для прохождения коллекции, от начала к концу
     *
     * @return итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return getElementByIndex(counter++);
            }
        };
    }

    /**
     * Итератор для прохождения коллекции, с конца в начало.
     *
     * @return итератор.
     */
    protected Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int counter = size - 1;

            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public E next() {
                return getElementByIndex(counter--);
            }
        };
    }


    /**
     * Вернуть элемент по индексу.
     *
     * @param index индекс.
     * @return элемент.
     */
    E getElementByIndex(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x.item;
    }

    /**
     * @return последний элемент списка
     */
    E getElementLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    /**
     * @return первый элемент списка
     */
    E getElementFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    /**
     * Удаляет первый элемент контейнера.
     * @return первый элемент контейнера.
     */
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null){
            throw new NoSuchElementException();
        }
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    /**
     * Удаляет последний элемент контейнера.
     * @return последний элемент контейнера.
     */
    public E removeLast() {
        final Node<E> l = last;
        if (l == null){
            throw new NoSuchElementException();
        }
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }
    /**
     * @param <E>
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        void setItem(E e) {
            item = e;
        }
    }
}
