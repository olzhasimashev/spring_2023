package com.example.postgresql_lab3.model;

import jakarta.persistence.*;

@Entity
@Table
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private boolean published;

    @Column
    private String someText;

    public Tutorial() {

    }

    public Tutorial(String title, String description, boolean published, String someText) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.someText = someText;
    }

    public long getId() {
        return id;
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

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    public String getSomeText() {return someText; }

    public void setSomeText(String someText) {this.someText = someText ;}

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }
}
