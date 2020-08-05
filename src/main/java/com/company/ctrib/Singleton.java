package com.company.ctrib;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * @description: 单例模式-双重检锁
 * @author: cfireworks
 * @create: 2020-06-15 11:28
 **/
public class Singleton {
    private static volatile Singleton singletonInstance;

    private static volatile Singleton eagerInstance = new Singleton();

    private Singleton(){}
    public static Singleton getSingletonInstance(){
        if(singletonInstance == null){
            synchronized (Singleton.class){
                if(singletonInstance == null){
                    return new Singleton();
                }
            }
        }
        return singletonInstance;
    }

    // 懒汉模式
    public static synchronized Singleton lazyGetInstance(){
        if(singletonInstance == null){
            singletonInstance = new Singleton();
        }
        return singletonInstance;
    }

    // 饿汉模式
    public static Singleton eagerGetInstance(){
        return eagerInstance;
    }

}
