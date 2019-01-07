package com.bgs.Login.threadAndIo;

import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 多线程下载文件
 *
 * 1、读取  线程同时读取，分片进行读取
 * 2、写入文件  同时往一个文件里面写入数据，每个线程设置写入的范围
 */

public class LoadFile {

    private static int threadCount = 3;// 下载的线程数量

    public static void main(String[] args) {

        // 1、与服务器建立连接，获得文件的大小，在本地创建一个与需下载文件同等大小的临时文件
        String path = "https://github.com/MicrosoftArchive/redis/releases/download/win-3.2.100/Redis-x64-3.2.100.zip";
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);

            int code = conn.getResponseCode();
            if(200 == code) {
                // 获得文件的长度
                int length = conn.getContentLength();
                System.out.println("文件总长度为："+length);
                // 在本地创建一个可以随机读取的与源文件同等大小的临时文件
                RandomAccessFile raf = new RandomAccessFile("E:\\ideaUI\\test\\Redis-x64-3.2.100.zip", "rwd");
                // 指定文件的长度
                raf.setLength(length);// 设置文件长度
                raf.close();

                // 2、实现多线程下载资源
                int blockSize = length / threadCount ;// 每个线程平均需要下载文件的大小
                for(int threadId = 1; threadId <= threadCount; threadId++) {
                    // 每个线程下载文件的初始位置和结束位置
                    int startIndex = (threadId-1) * blockSize;
                    int endIndex = threadId * blockSize - 1;
                    // 下载的最后一块的情况
                    if(threadCount == threadId) {
                        endIndex = length - 1;// 如果不减1的话，就超出了文件的范围
                    }
                    System.out.println("线程 "+threadId+"下载位置为："+startIndex+"--->"+endIndex);
                    // 启动下载线程
                    new DownloadThread(path, startIndex, endIndex, threadId).start();
                }
            } else {
                System.out.println("服务器出现错误");
            }
        } catch (Exception e) {
            System.out.println("连接服务器URL出现错误");
            e.printStackTrace();
        }

    }

}
