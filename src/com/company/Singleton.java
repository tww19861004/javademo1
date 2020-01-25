package com.company;

import java.io.Serializable;

public class Singleton  implements Serializable,Cloneable{

    private static volatile boolean isCreate = false;//默认是第一次创建
    /**
     * 1.构造方法私有化，外部不能new
     */
    private Singleton() {
        if(isCreate) {
            throw new RuntimeException("已然被实例化一次，不能在实例化");
        }
        isCreate = true;
    }


    //2.本类内部创建对象实例
    private static  volatile  Singleton instance;


    //3.提供一个公有的静态方法，返回实例对象
    public static  Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instance;
    }

    /**
     * 防止序列化破环
     * @return
     */
    private Object readResolve() {
        return instance;
    }

}
