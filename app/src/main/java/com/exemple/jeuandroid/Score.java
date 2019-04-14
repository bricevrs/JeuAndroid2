package com.exemple.jeuandroid;

public class Score {
    private final long id;
    private String nom;
    private int score;

    public Score(long id, String nom, int score){
        this.id = id;
        this.nom = nom;
        this.score = score;
    }

    public long getId() {
        return id;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
