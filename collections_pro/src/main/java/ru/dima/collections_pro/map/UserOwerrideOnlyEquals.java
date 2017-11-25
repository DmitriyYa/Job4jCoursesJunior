package ru.dima.collections_pro.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 4. Переопределить только equals [#1004]
 * <p>
 * Создать два объекта User, которые имеют одинаковые поля.
 * <p>
 * Создать карту Map<User, Object>
 * <p>
 * Добавить два объекта с пункта 3 в карту. Вывести карту на печать. Описать полученный результат словами.
 * <p>
 * При этом метод hashCode остается не переопределенным.
 */
public class UserOwerrideOnlyEquals extends User {

    private UserOwerrideOnlyEquals(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    public static void main(String[] args) {
        //Создать два объекта User, которые имеют одинаковые поля.
        User user1 = new UserOwerrideOnlyEquals("Dima", 3, new GregorianCalendar(1983, Calendar.APRIL, 15));
        User user2 = new UserOwerrideOnlyEquals("Dima", 3, new GregorianCalendar(1983, Calendar.APRIL, 15));

        //Создать карту Map<User, Object>
        Map<User, Object> map = new HashMap<>();

        //Добавить два объекта.
        map.put(user1, "one");
        map.put(user2, "two");

        //Вывести карту на печать.
        System.out.println(map);

        //Описать полученный результат словами.
        //В коллекцию добалились две записи.
        //У ключей хеш коды разные, значения  разные.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (children != user.children) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }
}
