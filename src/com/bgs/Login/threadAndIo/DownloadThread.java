package com.bgs.Login.threadAndIo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadThread extends Thread {

    private String path;// 服务器路径
    private int startIndex;// 块文件开始位置
    private int endIndex;// 快文件结束位置
    private int threadId;// 线程编号

    public DownloadThread() {

    }

    public DownloadThread(String path, int startIndex, int endIndex, int threadId) {
        this.path = path;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(15000);
            // 提交请求可以从指定位置读取文件
            conn.setRequestProperty("Range", "bytes=" + startIndex + "-" + endIndex);
            int code = conn.getResponseCode();
            // 请求全部文件成功返回200， 请求部分文件成功返回206
            if (206 == code) {
                RandomAccessFile raf = new RandomAccessFile("E:\\ideaUI\\test\\Redis-x64-3.2.100.zip", "rwd");
                // 随机文件从哪里读
                raf.seek(startIndex);// 定位文件
                InputStream is = conn.getInputStream();
                int len = 0;
                byte[] buffer = new byte[1024];
                while ((len = is.read(buffer)) != -1) {
                    raf.write(buffer, 0, len);
                }
                is.close();
                raf.close();
                System.out.println("线程" + threadId + "下载完毕!!!!");
            } else {
                System.out.println("线程"+threadId+"请求的部分资源失败");
            }

        } catch (Exception e) {
            System.out.println("下载线程的URL连接异常");
            e.printStackTrace();
        }
    }

}
