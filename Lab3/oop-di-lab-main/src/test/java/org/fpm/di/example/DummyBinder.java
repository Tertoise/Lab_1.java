package org.fpm.di.example;

import org.fpm.di.Binder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class DummyBinder implements Binder {
    List<Class<?>> classes = new ArrayList<>();
    HashMap<Class<?>, Class<?>> implementations = new HashMap<>();
    HashMap<Class<?>, Object> instances = new HashMap<>();

    @Override
    public <T> void bind(Class<T> clazz) {
        classes.add(clazz);
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        implementations.put(clazz, implementation);
    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        instances.put(clazz, instance);
    }
}
