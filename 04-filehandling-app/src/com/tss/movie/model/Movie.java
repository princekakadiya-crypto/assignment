package com.tss.movie.model;

import java.io.Serializable;

public class Movie implements Comparable<Movie>, Serializable {
    private static int idCount=1;
    private int id;
    private String name;
    private String genre;
    private int year;

    public Movie(String name, String genre, int year) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.id=idCount++;
    }

    public static void setIdCount(int idCount) {
        Movie.idCount = idCount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Movie o) {
        return this.id-o.getId();
    }
    public void print()
    {
        System.out.printf("%10d %15s %15s %15d%n",id,name,genre,year);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                '}';
    }
}
