package ru.dima.collections_pro.generic;

/**
 * 5.2.2. Реализовать Store<T extends Base> [#157]
 * Сделать интерфейс Store<T extends Base>,
 * где Base - это абстрактный класс для моделей c методами String getId(); void setId(String id).
 * В интерфейсе должны быть методы
 * T add(T model)
 * T update(T model)
 * boolean delete(String id)
 * Методы добавить, обновить, удалить.
 * 1. Сделать два класса User, и Role которые наследуют Base класс.
 * 2. Сделать два класса хранилища UserStore и RoleStore. Внутри для хранения данных использовать SimpleArray.
 * 3. Помните. про инкапсуляцию.
 *      В методах store нельзя использовать методы c index,
 *      т.е. при реализации метода update вам необходимо найти в коллекции элемент с таким же id,
 *      как и переданный параметр, и если найден, то заменить его.
 * 4. После реализации проверьте можно ли избавиться от дублирования кода в вашем проекте.
 *      UserStore и RoleStore будут иметь один и тот же функционал.
 *      Общий для них функционал необходимо вынести в абстрактный класс AbstractStore.
 */
public interface Store<T extends Base> {
    /**
     * добавить
     * @param model
     * @return
     */
    void add(T model);

    /**
     * обновить
     * @param model
     * @return
     */
    boolean update(T model);

    /**
     * удалить
     * @param id
     * @return
     */
    boolean delete(String id);

}
