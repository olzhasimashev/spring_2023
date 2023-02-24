package com.example.sis3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "course")
    private int course;

    @Column(name = "special")
    private String special;

    public Student() {

    }

    public Student(String lastname, String firstname, int course, String special) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.course = course;
        this.special = special;
    }

    public long getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", course=" + course + ", speciality" + special + "]";
    }
}