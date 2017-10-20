package by.javaeducation.repository.jpa;

import by.javaeducation.model.Item;
import by.javaeducation.repository.ItemRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ItemRepoImpl implements ItemRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Item save(Item item) {
        if (item.isNew()) {
            entityManager.persist(item);
            return item;
        } else return entityManager.merge(item);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return entityManager.createNamedQuery(Item.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Item get(int id) {
        return entityManager.find(Item.class, id);
    }

    @Override
    public List<Item> getAll() {
        return entityManager.createNamedQuery(Item.ALL, Item.class).getResultList();
    }
}
