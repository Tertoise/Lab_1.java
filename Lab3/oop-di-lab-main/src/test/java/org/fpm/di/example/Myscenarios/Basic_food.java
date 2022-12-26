package org.fpm.di.example.Myscenarios;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Basic_food {
    private final Bread bread;
    private  final Milk milk;

    @Inject
    public  Basic_food(Bread b, Milk m){
        this.bread = b;
        this.milk = m;
    }

    public Bread getBread(){
        return bread;
    }

    public Milk getMilk(){
        return milk;
    }
}
