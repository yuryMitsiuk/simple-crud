package by.javaeducation.service;

import by.javaeducation.model.Item;

import java.util.List;

public interface ItemService {

    Item save(Item item);
    void delete(int id);
    Item update(Item item);
    Item get(int id);
    List<Item> getAll();

}
