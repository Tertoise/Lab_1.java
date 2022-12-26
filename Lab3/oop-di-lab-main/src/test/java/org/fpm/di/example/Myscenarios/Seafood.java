package org.fpm.di.example.Myscenarios;


import javax.inject.Inject;

public class Seafood {
    private final Alcohol alcohol;

    @Inject
    public Seafood(Alcohol a){
        this.alcohol = a;
    }

    public Alcohol getAlcohol(){
        return alcohol;
    }
}
