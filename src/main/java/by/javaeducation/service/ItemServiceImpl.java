package by.javaeducation.service;

import by.javaeducation.model.Item;
import by.javaeducation.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    ItemRepo itemRepo;

    @Override
    public Item save(Item item) {

        return itemRepo.save(item);
    }

    @Override
    public void delete(int id) {
        itemRepo.delete(id);
    }

    @Override
    public Item update(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public Item get(int id) {
        return itemRepo.get(id);
    }

    @Override
    public List<Item> getAll() {
        return itemRepo.getAll();
    }
}
