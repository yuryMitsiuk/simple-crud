package by.javaeducation.model;

import java.time.LocalDateTime;

public class Item extends NamedEntity {

    private LocalDateTime dateDelivery;

    private Integer quantity;

    private boolean enable;

    public Item(Integer id, String title, LocalDateTime dateDelivery, Integer quantity, boolean enable) {
        super(id, title);
        this.dateDelivery = dateDelivery;
        this.quantity = quantity;
        this.enable = enable;
    }

    public Item(String title, LocalDateTime dateDelivery, Integer quantity, boolean enable) {
        this(null, title, dateDelivery, quantity, enable);
    }

    public LocalDateTime getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(LocalDateTime dateDelivery) {
        this.dateDelivery = dateDelivery;
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
                ", dateDelivery = " + dateDelivery +
                ", quantity = " + quantity +
                ", enable = " + enable +" }";
    }
}
