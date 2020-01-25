package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Singleton  singleton = Singleton.getInstance();
        Class<?> classType =Singleton.class;
        Constructor<?> c = classType.getDeclaredConstructor(null);
        c.setAccessible(true);
        Singleton e1 = (Singleton)c.newInstance();
        Singleton e2 = Singleton.getInstance();
        System.out.println(e1==e2);
    }
}
