package org.fpm.di.example;

import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.fpm.di.example.Myscenarios.*;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }

///////////////////////////////////////// MY TESTS

    @Test
    public void Basic_test(){
        assertSame(container.getComponent(MainClass.class), container.getComponent(Injecting.class));
        final Injecting getBasic = container.getComponent(Injecting.class);
        final Singletoned getSingleton = container.getComponent(Injecting.class).getSingleton();
        assertNotSame(getBasic.getBasic(), container.getComponent(Basic.class));
        assertSame(getSingleton, container.getComponent(Singletoned.class));

    }

    @Test
    public void Class_copy_test(){
        final SecondaryInjecting getSecondary_1 = container.getComponent(SecondaryInjecting.class);
        final SecondaryInjecting getSecondary_2 = container.getComponent(SecondaryInjecting.class);
        assertNotSame(getSecondary_1, getSecondary_2);
        assertNotSame(getSecondary_1.getBasic(), getSecondary_2.getBasic());
        assertSame(getSecondary_1.getSingleton(), getSecondary_2.getSingleton());
        final Injecting getInjecting = container.getComponent(Injecting.class);
        assertSame(getSecondary_1.getSingleton(), getInjecting.getSingleton());
        assertNotSame(getSecondary_1.getBasic(), getInjecting.getBasic());
    }

    @Test
    public void General_test(){
        final Products getproducts = container.getComponent(Products.class);
        final Basic_food getfood = container.getComponent(Basic_food.class);
        final Waterbased getwater = container.getComponent(Waterbased.class);
        final Milk getmilk = container.getComponent(Milk.class);
        assertSame(getfood.getBread().getSandwich(), getmilk.getSandwich());
        assertSame(getwater.getNon_alcohol(), getwater.getNon_alcohol());
        assertSame(getproducts.getBasic_food().getBread().getSandwich(), getproducts.getBasic_food().getMilk().getSandwich());
        assertSame(container.getComponent(Bread.class), getfood.getBread());
        assertSame(getwater.getNon_alcohol(), container.getComponent(Non_alcohol.class));
        assertSame(container.getComponent(Lemonades.class), getwater.getNon_alcohol());
        assertSame(container.getComponent(Sandwich.class), getmilk.getSandwich());
        assertNotSame(container.getComponent(Milk.class), getfood.getMilk());
        assertNotSame(container.getComponent(Seafood.class), getproducts.getLux().getSeafood());
        assertNotSame(getproducts.getWaterbased().getAlcohol(), getproducts.getLux().getSeafood().getAlcohol());
        assertNotSame(getwater.getAlcohol(), getproducts.getLux().getSeafood().getAlcohol());
        assertNotSame(getproducts, container.getComponent(Products.class));
    }
}
