package com.bgs.Login.socketTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
//服务器类
public class TalkServer {

    public static void main(String[] args) {
        try {
            ServerSocket server =  new ServerSocket(4700);//创建指定端口
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));//由Socket对象得到输入流，并构造相应的BufferedReader对象
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//由Socket对象得到输出流，并构造BufferedWriter对象

            String line = is.readLine();

            while(!line.equals("exit")) {
                System.out.println("Client：" + line);
                String send = in.readLine();
                out.write(send,0,send.length());
//                out.write("你好");
                out.newLine();
                out.flush();
                line = is.readLine();
            }
            is.close();
            socket.close();
            server.close();
        }
        catch(Exception e){
            System.out.println("Error" + e);
        }
    }

}
