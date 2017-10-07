package by.javaeducation.repository;

import by.javaeducation.model.Item;

import java.util.List;

public interface ItemRepo {
    Item save(Item item);
    boolean delete(int id);
    Item get(int id);
    List<Item> getAll();
}
