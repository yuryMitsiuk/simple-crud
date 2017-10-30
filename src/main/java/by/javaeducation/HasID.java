package by.javaeducation;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface HasID {
    Integer getId();

    void setId(Integer id);

    @JsonIgnore
    default boolean isNew() {
        return getId() == null;
    }
}
