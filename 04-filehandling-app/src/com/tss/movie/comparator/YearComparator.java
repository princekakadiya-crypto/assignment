package com.tss.movie.comparator;

import com.tss.movie.model.Movie;

import java.util.Comparator;

public class YearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getYear()- o2.getYear();
    }
}
