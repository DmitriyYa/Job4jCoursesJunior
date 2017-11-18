package ru.dima.collections_pro.list;

/**
 * 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack и Queue. [#160]
 * <p>
 * Используя контейнер на базе связанного списка создать контейнер Queue.
 * <p>
 * <p>
 * public class SimpleQueue<T> {
 * public <T> poll()
 * <p>
 * public void push(T value);
 * }
 * <p>
 * метод poll - должен возвращать значение и удалять его из коллекции.
 */
public class SimpleQueue<T> {
    /**
     * Контейнер.
     */
    private LinkedList<T> linkedList;

    /**
     * Конструктор по умалчянию.
     */
    public SimpleQueue() {
        this.linkedList = new LinkedList<>();
    }

    /**
     * Возвращает и удуляет первый элемент контейнера.
     *
     * @return первый элемент контейнера.
     */
    T pool() {
        if (linkedList.getSize() <= 0) {
            return null;
        } else {
            T element = linkedList.get(0);
            linkedList.removeFirst();
            return element;
        }

    }

    /**
     * всдавляет элемент первым в контейнер.
     *
     * @param value элемент.
     */
    public void push(T value) {
        linkedList.addElementFirst(value);
    }


    /**
     * @param index индекс.
     * @return
     */
    public T get(int index){
        return linkedList.get(index);
    }
}
