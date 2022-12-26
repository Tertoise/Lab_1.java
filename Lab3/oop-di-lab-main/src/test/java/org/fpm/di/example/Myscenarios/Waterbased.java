package org.fpm.di.example.Myscenarios;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Waterbased {
    private final Non_alcohol non_alcohol;

    private final Alcohol alcohol;

    @Inject
    public Waterbased(Non_alcohol non, Alcohol a){
        this.non_alcohol = non;
        this.alcohol = a;
    }

    public Non_alcohol getNon_alcohol(){
        return  non_alcohol;
    }

    public Alcohol getAlcohol(){
        return alcohol;
    }
}
