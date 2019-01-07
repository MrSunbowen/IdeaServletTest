package com.bgs.Login.array;

import java.io.*;
import java.util.Random;
/*
* 随机生成5000个整数，将整数存入文件
* 读取文件，将文件存入ArrayList
* 进行查处最大数、最小数、排序
* */
public class RandomTest {

    public static void main(String[] args) throws IOException {

        /*BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\ideaUI\\test\\rand.html"),"UTF-8"));
        for (int i = 0; i <5000 ; i++) {
            int a = new  Random().nextInt(20000);
            bw.write(a+",");
        }
        bw.flush();
        bw.close();*/

        MyArrayList<Integer> ml = new MyArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\ideaUI\\test\\rand.html"),"utf-8"));

        String line;
        String[] num = null;
        while ((line = br.readLine())!=null){
            num = line.split(",");
        }
        for (int i = 0; i <num.length ; i++) {
            ml.add(Integer.parseInt(num[i]));
        }

        System.out.println("长度为："+ml.size());
        System.out.println("最大值："+ml.getMax());
        System.out.println("最小值："+ml.getMin());
        //排序
        ml.arrayList();

        for (int i = 0; i < ml.size() ; i++) {
            System.out.println(ml.get(i));
        }


    }
}
