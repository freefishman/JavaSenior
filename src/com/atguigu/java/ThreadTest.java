package com.atguigu.java;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()方法 ——> 将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start()
 *
 * 例子：遍历100以内的所有偶数
 *
 * @author q2Lin
 * @create 2020-08-25-19:52
 */

//1.创建一个继承于Thread类的子类
class Mythread extends Thread{
    //2.重写Thread类的run()方法
    public Mythread(String name){
        super(name);
    }
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类对象
        Mythread t1 = new Mythread("线程1");
        //4.通过此对象调用start():①启动当前线程 ②调用当前线程的run()方法
        t1.start();
        //问题一：我们不能通过直接调用run()的方式启动线程
        //t.run();

        //问题二：再启动一个线程，遍历100以内的偶数
        //t1.start();不能还让已经start的线程去执行，会报IllegalThreadStateException
        Mythread t2 = new Mythread("线程2");//需要重新创建一个线程的对象
        t2.start();

        //如下操作仍然是在main线程中执行的
        for(int i = 0; i < 100; i++){
                System.out.println(Thread.currentThread().getName() + ":" + "***********************");
        }
    }
}
