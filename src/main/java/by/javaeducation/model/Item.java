package by.javaeducation.model;

import java.time.LocalDateTime;

public class Item extends NamedEntity {

    private LocalDateTime delivery;

    private Integer quantity;

    private boolean enable;

    public Item(Integer id, String title, LocalDateTime delivery, Integer quantity, boolean enable) {
        super(id, title);
        this.delivery = delivery;
        this.quantity = quantity;
        this.enable = enable;
    }

    public Item(String title, LocalDateTime delivery, Integer quantity, boolean enable) {
        this(null, title, delivery, quantity, enable);
    }

    public LocalDateTime getDelivery() {
        return delivery;
    }

    public void setDelivery(LocalDateTime delivery) {
        this.delivery = delivery;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Item { id = "+getId()+
                ", title = " + getTitle() +
                ", dateDelivery = " + delivery +
                ", quantity = " + quantity +
                ", enable = " + enable +" }";
    }
}
