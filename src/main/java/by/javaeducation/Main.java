package by.javaeducation;

import by.javaeducation.model.Item;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Start simple crud application!");
        Item item = new Item(10, "Item1", LocalDateTime.now(), 1000, false);
        System.out.printf(item.toString());
    }
}
