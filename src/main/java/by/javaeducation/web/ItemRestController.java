package by.javaeducation.web;

import by.javaeducation.model.Item;
import by.javaeducation.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ItemRestController {

    private static final Logger LOG = LoggerFactory.getLogger(ItemRestController.class);

    @Autowired
    private ItemService service;

    public Item create(Item item) {
        LOG.info("create {}.", item);
        return service.save(item);
    }

    public void delete(int id) {
        LOG.info("delete item id = {}.", id);
        service.delete(id);
    }

    public Item get(int id) {
        LOG.info("get item id = {}.", id);
        return service.get(id);
    }

    public Item update(Item item) {
        LOG.info("update {}.", item);
        return service.update(item);
    }

    public List<Item> getAll() {
        LOG.info("get all items.");
        return service.getAll();
    }
}
