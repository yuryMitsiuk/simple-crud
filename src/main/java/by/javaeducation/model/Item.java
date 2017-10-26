package by.javaeducation.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@NamedQueries({
        @NamedQuery(name = Item.DELETE, query = "DELETE FROM Item i WHERE i.id=:id"),
        @NamedQuery(name = Item.ALL, query = "SELECT i FROM Item i ORDER BY i.delivery DESC")
})
@Entity
@Table(name = "items")
public class Item extends NamedEntity {

    public static final String DELETE = "Item.delete";
    public static final String ALL = "Item.all";

    @Column(name = "delivery", columnDefinition = "timestamp default now()")
    @NotNull
    private LocalDateTime delivery;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "enabled", columnDefinition = "bool default false")
    private boolean enable;

    public Item() {
    }

    @JsonCreator
    public Item(@JsonProperty("id") Integer id,
                @JsonProperty("title") String title,
                @JsonProperty("delivery") LocalDateTime delivery,
                @JsonProperty("quantity") Integer quantity,
                @JsonProperty("enable") boolean enable) {
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
