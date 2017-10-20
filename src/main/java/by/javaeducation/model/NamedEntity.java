package by.javaeducation.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NamedEntity extends BaseEntity {

    @NotBlank
    @Length(min = 5)
    @Column(name = "title", nullable = false)
    protected String title;

    public NamedEntity() {
    }

    public NamedEntity(Integer id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Entity %s (%s, '%s')",
                getClass().getName(), getId(), title);
    }
}
