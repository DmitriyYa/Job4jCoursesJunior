package ru.dima.collections_pro.generic;

public class RoleStore implements Store {

    private SimpleArray simpleArray;

    public RoleStore() {
        this.simpleArray = new SimpleArray(10);
    }

    public Base add(Base model) {
        return null;
    }

    public Base update(Base model) {
      return null;
    }

    public boolean delete(String id) {
        return false;
    }
}
