package ru.dima.collections_pro.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/*
5. Перекрывать и equals и hashCode [#1002]

Создать два объекта User, которые имеют одинаковые поля.

Создать карту Map<User, Object>

Добавить два объекта с пункта 3 в карту. Вывести карту на печать. Описать полученный результат словами.
 */
public class UserOwerrideEqualsAndHashCode extends User {

    private UserOwerrideEqualsAndHashCode(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    public static void main(String[] args) {
        //Создать два объекта User, которые имеют одинаковые поля.
        User user1 = new UserOwerrideEqualsAndHashCode("Dima", 3, new GregorianCalendar(1983, Calendar.APRIL, 15));
        User user2 = new UserOwerrideEqualsAndHashCode("Dima", 3, new GregorianCalendar(1983, Calendar.APRIL, 15));

        //Создать карту Map<User, Object>
        Map<User, Object> map = new HashMap<>();

        //Добавить два объекта.
        map.put(user1, "one");
        map.put(user2, "two");

        //Вывести карту на печать.
        System.out.println(map);

        //Описать полученный результат словами.
        //при добавлении в коллекцию, второй объект затер первый, т.к. имеет одинаковый ключ.
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
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
