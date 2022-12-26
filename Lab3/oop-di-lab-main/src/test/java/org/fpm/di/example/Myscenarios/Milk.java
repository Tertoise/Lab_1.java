package org.fpm.di.example.Myscenarios;

import javax.inject.Inject;

public class Milk {
    private final Sandwich sandwich;

    @Inject
    public  Milk(Sandwich s){
        this.sandwich = s;
    }

    public Sandwich getSandwich(){
        return sandwich;
    }
}
