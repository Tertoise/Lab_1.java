package org.fpm.di.example;

import org.fpm.di.Container;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.Class;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class DummyContainer implements Container {
    DummyBinder binder;

    DummyContainer (DummyBinder binder_cons){
        this.binder = binder_cons;
    }

    @Override
    public <T> T getComponent(Class<T> clazz) {
        if (binder.implementations.containsKey(clazz)){
            return getComponent((Class<T>) binder.implementations.get(clazz));
        }
        if (binder.instances.containsKey(clazz)){
            return (T) binder.instances.get(clazz);
        }
        try {
            T temp = null;
            for (Constructor<?> constructor : clazz.getConstructors()){
                if (constructor.isAnnotationPresent(Inject.class)){
                    Parameter[] parameters = constructor.getParameters();
                    Object[] objects = new Object[parameters.length];
                    for (int i = 0; i < parameters.length; i++){
                        objects[i] = getComponent((parameters[i]).getType());
                    }
                    temp = (T) constructor.newInstance(objects);
                    break;
                }
            }
            if (temp == null){
                temp = clazz.newInstance();
            }
            if (clazz.isAnnotationPresent(Singleton.class)){
                binder.bind(clazz, temp);
            }
            return temp;
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e){
            throw new RuntimeException(e);
        }
    }
}
