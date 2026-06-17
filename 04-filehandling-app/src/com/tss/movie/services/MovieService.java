package com.tss.movie.services;

import com.tss.Validation.InputValidation;
import com.tss.movie.model.Movie;
import com.tss.movie.repository.MovieRepository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    MovieRepository movieRepository=new MovieRepository();
    Scanner scanner=new Scanner(System.in);
    public void addMovie()
    {
        String name= InputValidation.readString("Enter Name : ",1,50,"Invalid input");
        String genre=InputValidation.readString("Enter Genre : ",1,50,"Invalid input");
        int year=Integer.parseInt(InputValidation.readNumberWithLength("Enter Year : ",4,4,"Invalid year"));
        Movie movie=movieRepository.addMovie(new Movie(name,genre,year));
        System.out.println("Movie added with MovieID : "+movie.getId());
    }

    public void removeMovie()
    {
        int id=InputValidation.readInt("Enter Movie Id : ");
        Movie movie=movieRepository.searchMovieById(id);
        if (movie==null)
        {
            System.out.println("Movie not found check your id");
            return;
        }
        movieRepository.removeMovie(movie);
        System.out.println("Movie Removed..");
    }

    public void displayMovieById()
    {
        List<Movie> movies=movieRepository.getMovieSortById();
        if (movies.isEmpty())
        {
            System.out.println("No movies found : ");
        }
        System.out.printf("%10s %15s %15s %15s%n","Movie Id","Name","Genre","Year");
        for (Movie movie:movies)
            movie.print();
    }
    public void displayMovieByName()
    {
        List<Movie> movies=movieRepository.getMovieSortByName();
        if (movies.isEmpty())
        {
            System.out.println("No movies found : ");
        }
        System.out.printf("%10s %15s %15s %15s%n","Movie Id","Name","Genre","Year");
        for (Movie movie:movies)
            movie.print();
    }
    public void displayMovieByYear()
    {
        List<Movie> movies=movieRepository.getMovieSortByYear();
        if (movies.isEmpty())
        {
            System.out.println("No movies found : ");
        }
        System.out.printf("%10s %15s %15s %15s%n","Movie Id","Name","Genre","Year");
        for (Movie movie:movies)
            movie.print();
    }
    public void searchMovieById()
    {
        int id=InputValidation.readInt("Enter Movie Id : ");
        Movie movie=movieRepository.searchMovieById(id);
        if (movie==null)
        {
            System.out.println("Movie not found check your id");
            return;
        }
        System.out.println(movie);
    }

    public void displayMoviesFromFile()
    {
        try {
            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("movies.ser"));
            ArrayList<Movie> movies=(ArrayList<Movie>) objectInputStream.readObject();
            System.out.printf("%10s %15s %15s %15s%n","Movie Id","Name","Genre","Year");
            System.out.println("------------------------------------------------------");
            for (Movie movie:movies)
                movie.print();
        }
        catch (Exception e)
        {
            System.out.println("No Movie found...");
        }

    }

    public void saveMoviesToFile()
    {
        try {
            List<Movie> movies = movieRepository.getMovies();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("movies.ser"));
            objectOutputStream.writeObject(movies);
            objectOutputStream.close();
            System.out.println("file saved...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void initList ()
    {
        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("movies.ser"));) {
            ArrayList<Movie> movies=(ArrayList<Movie>) objectInputStream.readObject();
            if (movies.isEmpty())
                return;
            movieRepository.initMovieList(movies);
        } catch (Exception e) {

        }
    }
    public void exit()
    {
        System.out.println("If you want to save the progress enter y : ");
        char ch=scanner.next().charAt(0);
        if (ch=='y')
        {
            saveMoviesToFile();
        }
                System.out.println("Exited...");
    }
}
