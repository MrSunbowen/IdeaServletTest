package com.bgs.Login.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIp {

    public static void main(String[] args) {

        InetAddress address = null;
        try {
            address = InetAddress.getByName("www.baidu.com");
            System.out.println(address.getHostName() + "=" + address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("Local HostAddress:"+addr.getHostAddress());
                            String hostname = addr.getHostName();
            System.out.println("Local host name: "+hostname);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
