package com.tss.movie.repository;

import com.tss.movie.comparator.NameComparator;
import com.tss.movie.comparator.YearComparator;
import com.tss.movie.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieRepository {
    private List<Movie> movies=new ArrayList<>();

    public void initMovieList(List<Movie> movies)
    {
        this.movies=movies;
        Movie.setIdCount(movies.get(movies.size()-1).getId()+1);
    }
    public List<Movie> getMovies() {
        return movies;
    }

    public Movie addMovie(Movie movie)
    {
        movies.add(movie);
        return movie;
    }
    public Movie searchMovieById(int id)
    {
        for (Movie movie:movies)
        {
            if (movie.getId()==id)
                return movie;
        }
        return null;
    }
    public void removeMovie(Movie movie)
    {
        movies.remove(movie);
    }
    public List<Movie> getMovieSortById()
    {
        Collections.sort(movies);
        return movies;
    }
    public List<Movie> getMovieSortByName()
    {
        Collections.sort(movies,new NameComparator());
        return movies;
    }
    public List<Movie> getMovieSortByYear()
    {
        Collections.sort(movies,new YearComparator());
        return movies;
    }
}
