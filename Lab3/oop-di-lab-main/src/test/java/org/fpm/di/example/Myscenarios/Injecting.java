package org.fpm.di.example.Myscenarios;


import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Injecting extends MainClass {

    private final Singletoned single;

    private final Basic basic;

    @Inject
    public Injecting(Singletoned k, Basic l){
        this.single = k;
        this.basic = l;
    }

    public Singletoned getSingleton() {
        return single;
    }

    public Basic getBasic() {
        return basic;
    }
}