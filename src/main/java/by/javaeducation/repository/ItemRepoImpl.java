package by.javaeducation.repository;

import by.javaeducation.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepoImpl implements ItemRepo {

    @Override
    public Item save(Item item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Item get(int id) {
        return null;
    }

    @Override
    public List<Item> getAll() {
        return null;
    }
}
