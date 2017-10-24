package by.javaeducation.repository.datajpa;

import by.javaeducation.model.Item;
import by.javaeducation.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ItemRepoImpl implements ItemRepo {

    private static final Sort sort = new Sort(Sort.Direction.DESC,"delivery");

    @Autowired
    private CrudRepo crudRepo;

    @Override
    public Item save(Item item) {
        return crudRepo.save(item);
    }

    @Override
    public boolean delete(int id) {
        return crudRepo.delete(id) != 0;
    }

    @Override
    public Item get(int id) {
        return crudRepo.findOne(id);
    }

    @Override
    public List<Item> getAll() {
        return crudRepo.findAll(sort);
    }
}
