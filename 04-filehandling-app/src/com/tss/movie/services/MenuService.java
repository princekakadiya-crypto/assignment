package com.tss.movie.services;

import com.tss.Validation.InputValidation;

import java.util.Scanner;

public class MenuService {
    private MovieService movieService=new MovieService();

    public void Start(){
        movieService.initList();
        int choice;
        do {

            System.out.println("1. load Movie from File");
            System.out.println("2. add Movie");
            System.out.println("3. Save Movie");
            System.out.println("4. search Movie");
            System.out.println("5. sort Movie");
            System.out.println("6. remove Movie");
            System.out.println("7. Exit");

            choice= InputValidation.readInt("Enter your choice : ");
            switch (choice)
            {
                case 1:
                    movieService.displayMoviesFromFile();
                    break;
                case 2:
                    movieService.addMovie();
                    break;
                case 3:
                    movieService.saveMoviesToFile();
                    break;
                case 4:
                    movieService.searchMovieById();
                    break;
                case 5:
                    sortMenu();
                    break;
                case 6:
                    movieService.removeMovie();
                    break;
                case 7:
                    movieService.exit();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while (choice!=7);
    }
    private void sortMenu()
    {
        int choiceSort;
        do {
            System.out.println("1. Sort By ID");
            System.out.println("2. Sort By Movie Name");
            System.out.println("3. Sort by Year");
            System.out.println("4. Back");
            choiceSort = InputValidation.readInt("Enter your choice");

            switch (choiceSort)
            {
                case 1:
                    movieService.displayMovieById();
                    break;
                case 2:
                    movieService.displayMovieByName();
                    break;
                case 3:
                    movieService.displayMovieByYear();
                    break;
                case 4:
                    System.out.println("Back from Sort Menu");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }while (choiceSort!=4);

    }

}
