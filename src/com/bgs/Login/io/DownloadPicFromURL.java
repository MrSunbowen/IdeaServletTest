package com.bgs.Login.io;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 截取当前页面
 */
public class DownloadPicFromURL {
    public static void main(String[] args) {
        try {
            Robot robot=new Robot();
            //根据指定的区域抓取屏幕的指定区域，1300是长度，800是宽度。
            BufferedImage bi=robot.createScreenCapture(new Rectangle(1300,800));
            //把抓取到的内容写到一个jpg文件中
            ImageIO.write(bi, "jpg", new File("E:\\ideaUI\\test\\pic.jpg"));

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

