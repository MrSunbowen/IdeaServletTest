package com.bgs.Login.io;

import java.io.*;

/**
 * 读取a和b文件，交替写入c文件
 */
public class ioTest {

    public static void main(String[] args) {
        try {
            fileRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fileRead() throws Exception {
        File file = new File("E:\\ideaUI\\test\\c.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader bra = new BufferedReader(new FileReader("E:\\ideaUI\\test\\a.txt"));
        BufferedReader brb = new BufferedReader(new FileReader("E:\\ideaUI\\test\\b.txt"));

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        String readline;
        StringBuffer sba = new StringBuffer();
        StringBuffer sbb = new StringBuffer();

        while((readline = bra.readLine()) != null){
            sba.append(readline);
        }
        while((readline = brb.readLine()) != null){
            sbb.append(readline);
        }
        String[] aArray = sba.toString().split("\\s");
        String[] bArray = sbb.toString().split("\\s");

        if (aArray.length>bArray.length){
            for (int a = 0; a<aArray.length;a++){
                if (bArray.length<a){
                    bw.write(aArray[a]+",");
                }else {
                    bw.write(aArray[a]+",");
                    bw.write(bArray[a]+"\n");
                }
            }
        }else {
            for (int a = 0; a<bArray.length;a++){
                if (aArray.length<=a){
                    bw.write(bArray[a]+"\n");
                }else {
                    bw.write(aArray[a]+",");
                    bw.write(bArray[a]+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
        brb.close();
        bra.close();

    }


}
