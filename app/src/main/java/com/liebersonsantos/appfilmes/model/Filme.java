package com.liebersonsantos.appfilmes.model;

public class Filme {

    private String title;
    private final String poster_path;

    public Filme(String title, String poster_path) {
        this.title = title;
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }
}
