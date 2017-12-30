package com.imotiontech;

public class Greeting {

    private long id;
    private String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    // default constructor is need for http POST
    public Greeting() {}

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String toString() {
        return id + ", " + content;
    }
}