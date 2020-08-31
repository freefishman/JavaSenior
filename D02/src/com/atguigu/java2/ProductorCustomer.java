package com.atguigu.java2;

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 *  * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 *  * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员
 *  * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
 *  * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *  *
 * @author q2Lin
 * @create 2020-08-26-19:04
 */
class Clerk1{
    private int product = 0;
    public synchronized void consumeProduct() {
        if(product > 0){
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + product + "个产品");
            product--;
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void produceProduct() {
        if(product < 20){
            product++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + product + "个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Customer implements Runnable{
    private Clerk1 clerk;
    public Customer(Clerk1 c) {
        this.clerk = c;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：开始消费产品....");
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}
class Productor implements Runnable{
    private Clerk1 clerk;
    public Productor(Clerk1 c) {
        this.clerk = c;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：开始生产产品....");
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

public class ProductorCustomer {
    public static void main(String[] args) {
        Clerk1 c = new Clerk1();

        Customer customer = new Customer(c);
        Productor productor = new Productor(c);

        Thread t1 = new Thread(customer);
        t1.setName("消费者");
        Thread t2 = new Thread(productor);
        t2.setName("生产者");

        t1.start();
        t2.start();
    }
}
