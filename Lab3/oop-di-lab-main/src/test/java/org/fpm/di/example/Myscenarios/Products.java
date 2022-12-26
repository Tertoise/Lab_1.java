package org.fpm.di.example.Myscenarios;

import javax.inject.Inject;

public class Products {

    private final Waterbased waterbased;
    private final Basic_food basic_food;
    private final Luxury lux;


    @Inject
    public Products(Waterbased w, Basic_food f, Luxury l){
        this.waterbased = w;
        this.basic_food = f;
        this.lux = l;
    }

    public Waterbased getWaterbased(){
        return waterbased;
    }
    public Basic_food getBasic_food(){
        return basic_food;
    }
    public Luxury getLux(){
        return lux;
    }
}
