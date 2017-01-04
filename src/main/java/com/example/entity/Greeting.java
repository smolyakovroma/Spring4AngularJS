package com.example.entity;

import lombok.Getter;

@Getter
public class Greeting {

    private final long id;
    private final String content;

    public Greeting( long id, String content) {
        this.content = content;
        this.id = id;
    }
}
