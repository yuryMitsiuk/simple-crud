package by.javaeducation.service;

import by.javaeducation.TestData.ItemTestData;
import by.javaeducation.model.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static by.javaeducation.TestData.ItemTestData.*;

public class ItemServiceImplTest extends ServiceTest {

    @Autowired
    private ItemService service;

    @Test
    public void save() throws Exception {
        Item newItem = getCreated();
        service.save(newItem);
        MATCHER.assertListEquals(service.getAll(), Arrays.asList(newItem, item6, item5, item4, item3, item2, item1));
    }

    @Test
    public void delete() throws Exception {
        service.delete(ID_ITEM_1);
        MATCHER.assertListEquals(service.getAll(), Arrays.asList(item6, item5, item4, item3, item2));
    }

    @Test
    public void update() throws Exception {
        Item updatedItem = getUpdated();
        service.update(updatedItem);
        MATCHER.assertEquals(updatedItem, service.get(ID_ITEM_1));
    }

    @Test
    public void get() throws Exception {
        MATCHER.assertEquals(service.get(ID_ITEM_1), item1);
    }

    @Test
    public void getAll() throws Exception {
        List<Item> allItems = service.getAll();
        MATCHER.assertListEquals(allItems, ItemTestData.items);
    }

}