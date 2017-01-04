package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter @Setter
public class Note {

    @Id
    @GeneratedValue
    private long id;
    private String text;

    @JsonIgnore
    @ManyToOne
    private User user;

    public Note(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Note() {
    }
}
