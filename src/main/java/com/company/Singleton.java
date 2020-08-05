package com.company;

/**
 * @description: 单例模式
 * @author: cfireworks
 * @create: 2020-03-26 13:24
 **/
public class Singleton {
    private volatile static Singleton uniqueInstance;
    private Singleton(){}
    public static Singleton getInstance(){
        if(uniqueInstance == null){
            synchronized (Singleton.class){
                if(uniqueInstance==null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
