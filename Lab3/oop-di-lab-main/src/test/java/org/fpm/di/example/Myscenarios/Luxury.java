package org.fpm.di.example.Myscenarios;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Luxury {
    private final Seafood seafood;

    @Inject
    public Luxury(Seafood s){
        this.seafood = s;
    }

    public Seafood getSeafood(){
        return seafood;
    }
}
