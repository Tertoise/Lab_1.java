package org.fpm.di.example.Myscenarios;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Bread {
    private final Sandwich sandwich;

    @Inject
    public  Bread(Sandwich s){
        this.sandwich = s;
    }

    public Sandwich getSandwich(){
        return sandwich;
    }
}
