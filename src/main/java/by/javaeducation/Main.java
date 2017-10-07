package by.javaeducation;

import by.javaeducation.model.Item;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Start simple crud application!\n");
        Item item = new Item(10, "Item1", LocalDateTime.now(), 1000, false);
        System.out.printf(item.toString()+"\n");
        try (ConfigurableApplicationContext ctxApp = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println(Arrays.toString(ctxApp.getBeanDefinitionNames()));
        }
    }
}
