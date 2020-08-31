package com.atguigu.java1;

/**
 * 使用同步机制将单例模式中的懒汉式改为线程安全的
 *
 * @author q2Lin
 * @create 2020-08-26-14:20
 */
public class BankTest {
}
class Bank{
    private Bank(){}

    private static Bank instance = null;

    public static Bank getInstance(){
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if(instance == null){
//
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二:效率更高
        if(instance == null){
            synchronized (Bank.class){
                if(instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}