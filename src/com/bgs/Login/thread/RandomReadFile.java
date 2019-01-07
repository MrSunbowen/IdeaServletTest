package com.bgs.Login.thread;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RandomReadFile extends Thread{

    int start;
    int len;
    ByteArrayOutputStream bout;

    RandomReadFile(int start,int len){
        this.start = start;
        this.len = len;
        this.bout = new ByteArrayOutputStream();
    }


    public static void main(String[] args) throws Exception {

        //起始时间
        long start = System.currentTimeMillis();

        File file = new File("d:\\jiaoxue\\product2.txt");
        //文件长度
        int fileSize = (int)file.length();
        int end = (int)fileSize / 2;
//        RandomAccessFile in = new RandomAccessFile(file, "r");

        /*in.seek(0);
        byte[] buffer = new byte[1024];
        int len = 0;
        String str = "";

        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        while (true){
            long leftSize = end - len;
            long readSize = Math.min(leftSize,buffer.length);

            if(leftSize <= 0){
                System.out.println("leftSize: " + leftSize);
                break;
            }
            int read = in.read(buffer,0,(int)readSize);
            bout.write(buffer,0,read);
            len += read;
        }


        // 后半段读取

        in.seek(end);
        int len2 = -1;
        ByteArrayOutputStream bout2 = new ByteArrayOutputStream();
        while ((len2 = in.read(buffer,0,buffer.length))!=-1){
            bout2.write(buffer,0,len2);
        }


        // 合并 bout 和  bout2


        FileOutputStream fout = new FileOutputStream("d:\\jiaoxue\\product.txt.bak");
        bout.writeTo(fout);
        bout2.writeTo(fout);
        fout.close();

        System.out.println(str);
        in.close();

        System.out.println("花费时间：" + (System.currentTimeMillis() - start));*/

        /*ByteArrayOutputStream b1 = readFile(in, 0, end);

        ByteArrayOutputStream b2 = readFile(in, end, -1);

        FileOutputStream fout2 = new FileOutputStream("d:\\jiaoxue\\product.txt.bak");
        b1.writeTo(fout2);
        b2.writeTo(fout2);
        // 关闭流
        fout2.close();
        in.close();

        System.out.println("花费时间：" + (System.currentTimeMillis() - start));*/




        // 启动两个线程，分段 读取文件
        int taskNum = 2;
        List<RandomReadFile> taskList = new ArrayList<>();

        int pageSize = (int)fileSize/taskNum;
        for(int i = 0; i < taskNum; i++){
            int startIndex = i * pageSize;
            RandomReadFile rf = new RandomReadFile(startIndex,pageSize);
            taskList.add(rf);
            rf.start();
        }
        // 计算 剩余的 字节数
        int leftSize = fileSize % pageSize;
        if(leftSize != 0){
            RandomReadFile rf = new RandomReadFile(fileSize - leftSize,leftSize);
            taskList.add(rf);
            rf.start();
        }

        // 等待两个线程结束
        for(RandomReadFile task : taskList){
            task.join();
        }


        // 合并 byteArrayOutputStream ， 输出到文件
        FileOutputStream fout = new FileOutputStream("d:\\jiaoxue\\product.txt.bak");
        for(RandomReadFile task : taskList){
            ByteArrayOutputStream bout = task.bout;
            bout.writeTo(fout);
        }
        fout.close();

        System.out.println("花费时间：" + (System.currentTimeMillis() - start));


    }


    public void run()  {
        File file = new File("d:\\jiaoxue\\product2.txt");
        RandomAccessFile in = null;
        try {
            in = new RandomAccessFile(file, "r");
            bout = readFile(in,start,len);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static ByteArrayOutputStream readFile(RandomAccessFile file,
                                                 long start, long len) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        // 定位到读的位置
        file.seek(start);
        int data = -1;
        int readSize = 0;

        while ((data = file.read()) != -1) {
            readSize++;
            // 如果长度大于0，判断是否已经超过这个长度
            if (len > 0 && readSize > len) break;
            bout.write(data);
        }
        return bout;
    }


    public static ByteArrayOutputStream readFile2(RandomAccessFile file,
                                                  long start, long len) throws Exception {

        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        return bout;

    }
}
