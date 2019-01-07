package com.bgs.Login.io;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * get请求，下载
 */
public class TestUrl {
    public static void main(String [] args) {
        String path = "https://github.com/doocs/advanced-java/blob/master/img/e-commerce-website-detail-page-architecture-1.png?raw=true";
        URL url = null;

        //从网络上下载一张图片
        InputStream inputStream = null;
        OutputStream outputStream = null;
        //建立一个网络链接
        HttpURLConnection con = null;
        try {
            url = new URL(path);
            con = (HttpURLConnection) url.openConnection();
            inputStream = con.getInputStream();
            outputStream = new FileOutputStream(new File("E:\\ideaUI\\test\\test.jpg"));
            int n = -1;
            byte b [] = new byte[1024];
            while ((n = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, n);
            }
            outputStream.flush();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }

}
