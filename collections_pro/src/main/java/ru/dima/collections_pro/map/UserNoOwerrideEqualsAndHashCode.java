package ru.dima.collections_pro.map;



import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 2. Не перекрывать equals hashCode [#1005]
 * <p>
 * Создать два объекта User, которые имеют одинаковые поля.
 * <p>
 * Создать карту Map<User, Object>
 * <p>
 * Добавить два объекта. Вывести карту на печать. Описать полученный результат словами.
 */
public class UserNoOwerrideEqualsAndHashCode extends User{

    private UserNoOwerrideEqualsAndHashCode(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    public static void main(String[] args) {
        //Создать два объекта User, которые имеют одинаковые поля.
        User user1 = new UserNoOwerrideEqualsAndHashCode("Dima", 3, new GregorianCalendar(1983, Calendar.APRIL, 15));
        User user2 = new UserNoOwerrideEqualsAndHashCode("Dima", 3, new GregorianCalendar(1983, Calendar.APRIL, 15));

        //Создать карту Map<User, Object>
        Map<User, Object> map = new HashMap<>();

        //Добавить два объекта.
        map.put(user1,"one");
        map.put(user2,"two");

        //Вывести карту на печать.
        System.out.println(map);

        //Описать полученный результат словами.
        //В коллекцию добалились две записи.
        //У ключей хеш коды разные, значения тоже разные.
    }

}
