package org.fpm.di.example.Myscenarios;

import javax.inject.Inject;

public class SecondaryInjecting extends SecondaryClass{
    private final Singletoned single;

    private final Basic basic;

    @Inject
    public SecondaryInjecting(Singletoned k, Basic l){
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
