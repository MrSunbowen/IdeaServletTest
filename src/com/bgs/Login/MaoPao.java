package com.bgs.Login;

import java.util.Arrays;

public class MaoPao {

    public static void main(String[] args) {
        int [] a = {0,1,5,7};
        int [] b = {2,4,6,8};

        int[] c=new int[a.length+b.length];
        int a1=0;
        int b1=0;
        int c1=0;
        while (a1 < a.length && b1 < b.length) {
            if(a[a1]<=b[b1]){
                c[c1++]=a[a1++];
            }else{
                c[c1++]=b[b1++];
            }
        }
        while(a1 < a.length){
            c[c1++] = a[a1++];
        }
        while(b1 < b.length){
            c[c1++] = b[b1++];
        }

/*
      //冒泡排序
        int num;
        for (int j=0;j<c.length-1;j++){
            for(int w=0;w<c.length-j-1;w++){
                if(c[w+1]<c[w]){
                    num=c[w];
                    c[w]=c[w+1];
                    c[w+1]=num;
                }
            }
        }
        }*/

       /* for(int i=0;i<c.length;i++){
            System.out.print(c[i]);
        }*/


    }
}
