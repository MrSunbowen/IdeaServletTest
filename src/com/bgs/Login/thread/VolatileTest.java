package com.bgs.Login.thread;

import java.util.concurrent.atomic.AtomicInteger;

/*
* 线程交叉运行
*
*解决线程同步
* 1、加锁，1》同步代码块用synchronized，保持多个线程同时操作一块任务时的原子性
*          2》lock也是加锁
* 2、volatile关键字，共享变量，过个线程操作一个变量时的原子性
*/

public class VolatileTest {
    static int count;
//    static volatile boolean flag = true;
    static boolean flag = true;
    static int sleep = 10;
    static int num = 1000;

    //自增的意思
    static AtomicInteger total = new AtomicInteger(0);

    public static void main(String[] args) throws Exception{

        Thread t1 = new Thread(()->{
            int i = 0;
            while(true){
                synchronized (VolatileTest.class){
                    while(flag == true){
                        i++;
                        count++;
                        //自增
                        total.incrementAndGet();
                        System.out.println("-------: " + count);
                        flag = false;
                        System.out.println("-------:flag: " + flag);
                    }
                }
                if(i >= num) break;

//                try {
//                    Thread.sleep(sleep);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            }
        });

        Thread t2 = new Thread(()->{
            int i = 0;
            while (true){
                synchronized (VolatileTest.class) {
                    while (flag == false) {
                        i++;
                        count++;
                        total.incrementAndGet();
                        System.out.println("=======: " + count);
                        flag = true;
                        System.out.println("=======flag: " + flag);
                    }
                }
                if(i >= num) break;
//                try {
//                    Thread.sleep(sleep);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
        //获取total的值
        System.out.println(total.get());

    }
}
