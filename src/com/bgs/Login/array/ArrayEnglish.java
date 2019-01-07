package com.bgs.Login.array;

public class ArrayEnglish {

        public static void main(String[] args) {
            String abc = "This is my first book";
            String[] aaa= abc.split(" ");
            for (int i = 0; i <aaa.length ; i++) {
                System.out.print(aaa[i]+" ");
            }

            System.out.println("\n");
            for (int i = aaa.length-1; i >=0 ; i--) {
                System.out.print(aaa[i]+" ");
            }
            System.out.println("\n");
            String d=null;
            for (int i = aaa.length-1; i >=0 ; i--) {
                System.out.print(" ");
                d = aaa[i];
                char[] dd = d.toCharArray();
                for (int j = dd.length - 1; j >= 0; j--) {
                    System.out.print(dd[j] + "");
                }

            }
    }
}
