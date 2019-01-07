package com.bgs.Login;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        /*int[] a = {1,2,3,4,5};

        int aa = 0;
        int bb = a.length - 1;
        for (int i = 0; i < a.length/2; i++) {
            aa = a[i];
            a[i]=a[bb-i];
            a[bb-i]=aa;
        }
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+",");
        }
*/
        /*
        int[] b = new int[a.length];
        int num = 0;
        for (int i = a.length - 1; i >= 0 ; i--) {
            b[num] = a[i];
            num++;
        }
        System.out.println();
        for (int i = 0; i < b.length ; i++) {
            System.out.print(b[i]);
        }*/

        //查看目录下所有的目录和文件
        File file = new File("d:\\jdk");
        getFileName(file);
    }

    public static void getFileName(File file){
        File[] files=file.listFiles();
        for (int i = 0; i <files.length ; i++) {
            if (files[i].isDirectory()){
                System.out.println("目录："+files[i]);
                getFileName(files[i]);
            }else {
                System.out.println("文件"+files[i]);
            }
        }
    }


}
