package ca.gbc.comp3095.cookbook.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}