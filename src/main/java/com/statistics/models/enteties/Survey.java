package com.statistics.models.enteties;

import javax.persistence.*;

@Entity
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private int id;


    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "description", nullable = false, unique = true)
    private String description;

    public Survey(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Survey(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
