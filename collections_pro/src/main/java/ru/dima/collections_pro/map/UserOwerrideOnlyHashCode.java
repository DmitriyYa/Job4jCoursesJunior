package ru.dima.collections_pro.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 3. Переопределить только hashCode [#1003]

 Создать два объекта User, которые имеют одинаковые поля.

 Создать карту Map<User, Object>

 Добавить два объекта с пункта 3 в карту. Вывести карту на печать. Описать полученный результат словами.
 */
public class UserOwerrideOnlyHashCode extends User{

    private UserOwerrideOnlyHashCode(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    public static void main(String[] args) {
        //Создать два объекта User, которые имеют одинаковые поля.
        User user1 = new UserOwerrideOnlyHashCode("Dima", 3, new GregorianCalendar(1983, Calendar.APRIL, 15));
        User user2 = new UserOwerrideOnlyHashCode("Dima", 3, new GregorianCalendar(1983, Calendar.APRIL, 15));

        //Создать карту Map<User, Object>
        Map<User, Object> map = new HashMap<>();

        //Добавить два объекта.
        map.put(user1,"one");
        map.put(user2,"two");

        //Вывести карту на печать.
        System.out.println(map);

        //Описать полученный результат словами.
        //В коллекцию добалились две записи.
        //У ключей хеш коды одинаковые, значения  разные.
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
