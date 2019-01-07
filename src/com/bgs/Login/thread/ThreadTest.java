package com.bgs.Login.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadTest {
    static List<Integer> list = new ArrayList<>();

    public void getInit(int num,int math){
        Random random = new Random();
        for (int i = 0; i < num ; i++) {
            list.add(random.nextInt(math));
        }
    }

    public int getSum(int start,int end){
        int num =0;
        for (int i = start; i < end ; i++) {
//            System.out.println(list.get(i));
            num = num + list.get(i);
        }
        return num;
    }

    class Work implements Runnable{
        int num = 0 ;
        int start;
        int end;

        public Work(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            System.out.println("start-"+start+"-----end-"+end);
            num = getSum(start,end);
            System.out.println(Thread.currentThread().getName()+"----count:"+num);
        }
    }

    public int getCount(int n) throws InterruptedException {
        int index = list.size();
        int count = 0;
        int a = 1;
        long start = System.currentTimeMillis();
        Thread[] thread = new Thread[n];
        Object[] objects = new Object[n];
        for (int i = 0; i < n ; i++) {
            int startIndex = i*index/n;
            int endIndex = index/n*a;
            if (i == n-1){
                endIndex = index;
            }
            Work work= new Work(startIndex,endIndex);
            objects[i] = work;
            thread[i] = new Thread(work);
            thread[i].start();
            a++;
        }

        for (int i = 0; i <n ; i++) {
            thread[i].join();
            Work work = (Work) objects[i];
            count = count + work.num;
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("time:"+time);
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest tt = new ThreadTest();
        //num-添加多少次值,math-在0-多少范围内取值
        tt.getInit(10,10);
        System.out.println(tt.getCount(3));

    }
}
