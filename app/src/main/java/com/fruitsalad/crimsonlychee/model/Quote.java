package com.fruitsalad.crimsonlychee.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quote {

    @SerializedName("author")
    private String author;
    @SerializedName("category")
    private String category;
    @SerializedName("id")
    private String id;
    @SerializedName("quote")
    private String quote;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", id='" + id + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}
