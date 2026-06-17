package com.tss.movie.test;

import com.tss.Validation.InputValidation;
import com.tss.movie.services.MenuService;
import com.tss.movie.services.MovieService;

public class MovieTest {

    public static void main(String[] args){
        MenuService menuService=new MenuService();
        menuService.Start();
    }

}
