package com.damiannguyen.blog;

public class PostForm {
    private String title;
    private String text;

    public java.lang.String getTitle() {
        return title;
    }

    public PostForm setTitle(java.lang.String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public PostForm setText(String text) {
        this.text = text;
        return this;
    }
}
