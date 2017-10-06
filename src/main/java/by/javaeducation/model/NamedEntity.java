package by.javaeducation.model;

public abstract class NamedEntity extends BaseEntity {

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
