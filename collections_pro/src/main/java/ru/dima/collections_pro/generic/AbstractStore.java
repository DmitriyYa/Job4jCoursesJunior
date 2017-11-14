package ru.dima.collections_pro.generic;

public abstract class AbstractStore implements Store<Base>{
    private SimpleArray<Base> bases = new SimpleArray<Base>(10);


    @Override
    public void add(Base model) {
        bases.add(model);
    }

    @Override
    public boolean update(Base model) {
        for (int i = 0; i < bases.getSize(); i++) {
            if (model.getId().equals(bases.get(i).getId())) {
                bases.update(Integer.parseInt(bases.get(i).getId()), model);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (int i = 0; i< bases.getSize(); i++){
            if (bases.get(i).getId().equals(id)){
                bases.delete(Integer.parseInt(id));
                return true;
            }
        }
        return false;
    }

}
