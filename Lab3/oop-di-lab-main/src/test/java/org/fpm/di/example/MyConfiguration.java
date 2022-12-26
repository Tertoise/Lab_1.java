package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;

import org.fpm.di.example.Myscenarios.*;

public class MyConfiguration implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseA.class);

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());

///////////////////////////////////////
        binder.bind(MainClass.class, Injecting.class);
        binder.bind(SecondaryClass.class, SecondaryInjecting.class);

        binder.bind(Non_alcohol.class, Lemonades.class);

    }
}
