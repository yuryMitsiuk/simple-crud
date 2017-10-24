package by.javaeducation.TestData;

import by.javaeducation.matcher.BeanMatcher;
import by.javaeducation.model.Item;

import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.time.LocalDateTime.of;
import static by.javaeducation.model.BaseEntity.SEQ;

public class ItemTestData {

    public static final int ID_ITEM_1 = SEQ;

    public static final Item item1 = new Item(ID_ITEM_1, "Item1", of(2017, Month.OCTOBER, 5, 9, 00), 75, false);
    public static final Item item2 = new Item(ID_ITEM_1+1, "Item2", of(2017, Month.OCTOBER, 6, 13, 00), 175, false);
    public static final Item item3 = new Item(ID_ITEM_1+2, "Item3", of(2017, Month.OCTOBER, 7, 19, 00), 35, false);
    public static final Item item4 = new Item(ID_ITEM_1+3, "Item4", of(2017, Month.OCTOBER, 8, 9, 35), 90, false);
    public static final Item item5 = new Item(ID_ITEM_1+4, "Item5", of(2017, Month.OCTOBER, 9, 14, 20), 12, false);
    public static final Item item6 = new Item(ID_ITEM_1+5, "Item6", of(2017, Month.OCTOBER, 10, 20, 45), 215, false);

    public static final List<Item> items = Arrays.asList(item6, item5, item4, item3, item2, item1);

    public static Item getCreated() {
        return new Item(null, "NewItem", of(2017, Month.OCTOBER, 25, 10, 00), 100, false);
    }

    public static Item getUpdated() {
        return new Item(ID_ITEM_1, "UpdatedItem", of(2017, Month.OCTOBER, 24, 11, 00), 15, false);
    }

    public static final BeanMatcher<Item> MATCHER = new BeanMatcher<>(
            ((expected, actual) -> expected == actual ||
                    (
                            Objects.equals(expected.getId(), actual.getId())) &&
                            Objects.equals(expected.getTitle(), actual.getTitle()) &&
                            Objects.equals(expected.getDelivery(), actual.getDelivery()) &&
                            Objects.equals(expected.getQuantity(), actual.getQuantity()) &&
                            Objects.equals(expected.isEnable(), actual.isEnable())
                    )
            );
}
