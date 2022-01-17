package com.DesignPatterns;

/*
Properties:
1.Creational design pattern
2.Only one instance of the class should exist
3.Other class should be able to get instance of SingleTon class
4.Used in logging, cache, sessions, drivers

Implementation:
1.Constructor should be private
2.Public method for returning instance
3.Instance type - private static

Initialisation Type:
1.Eager Initialisation
2.Lazy Initialisation
3.Thread safe method Initialisation
4.Thread safe block Initialisation
* */
public class Pattern1_Singleton {

    public static void main(String[] args) {
        SingletonThreadSafeBlock ob = SingletonThreadSafeBlock.getInstance();
        System.out.println(ob.hashCode());
    }

}

class SingletonEager {
    private static SingletonEager instance = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return instance;
    }
}

class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (instance == null)
            instance = new SingletonLazy();
        return instance;
    }
}

class SingletonThreadSafeMethod {
    private static SingletonThreadSafeMethod instance;

    private SingletonThreadSafeMethod() {
    }

    public static synchronized SingletonThreadSafeMethod getInstance() {
        if (instance == null) {
            instance = new SingletonThreadSafeMethod();
        }
        return instance;
    }
}

class SingletonThreadSafeBlock {
    private static SingletonThreadSafeBlock instance;

    private SingletonThreadSafeBlock() {
    }

    public static SingletonThreadSafeBlock getInstance() {

        if (instance == null) {
            synchronized (SingletonThreadSafeBlock.class) {
                if (instance == null)
                    instance = new SingletonThreadSafeBlock();
            }
        }
        return instance;
    }
}
