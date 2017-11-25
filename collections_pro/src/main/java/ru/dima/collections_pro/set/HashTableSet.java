package ru.dima.collections_pro.set;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 3. Реализовать коллекцию типа Set на базе хэш-таблицы [#998]
 * Напишите свою реализацию Set на базе хэш-таблицы. Реализуйте следующие методы:
 * 1) boolean add (E e)
 * 2) boolean contains (E e)
 * 3) boolean remove (E e)
 * <p>
 * Принципы организации хэш-таблиц вы сможете узнать из следующих источников:
 * 1) Wikipedia - хеш-таблица
 * 2) Core Java - К.Хорстманн
 * 3) Алгоритмы. Построение и анализ. - Т.Кормен и др.
 * 4) Алгоритмы и структуры данных. - Н. Вирт
 * <p>
 * Разрешение коллизий реализовывать не надо. Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента.
 */
public class HashTableSet<E> {

    /**
     * Коллекция для хранения пар( ключ, значение)
     */
    private HashMap<E, Object> map;

    /**
     * Значение.
     */
    private static final Object PRESENT = new Object();

    /**
     * Констркутор по умолчанию.
     */
    public HashTableSet() {
        this.map = new HashMap<>();
    }

    /**
     * Добавить элемент в коллекцию.
     * @param e
     * @return
     */
    boolean add(E e) {
        return this.map.put(e, PRESENT) == null;
    }

    /**
     * Есть ли такой элемент в коллекции.
     * @param e
     * @return
     */
    boolean contains(E e) {
        return this.map.containsKey(e);
    }

    /**
     * Удалить элемент из коллекции.
     * @param e
     * @return
     */
    boolean remove(E e) {
        return this.map.remove(e) == PRESENT;
    }

    /** Итератор для прохождения коллекции.
     * @return
     */
    public Iterator<E> iterator(){
        return this.map.keySet().iterator();
    }
}
