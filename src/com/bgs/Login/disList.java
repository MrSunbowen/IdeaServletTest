package com.bgs.Login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class disList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("aa");
        list.add("bb");

        Map<String,String> map = new HashMap<>();

        List<String> disList = new ArrayList<>();
        for (int i = 0; i < list.size() ; i++) {
            if (map.containsKey(list.get(i))){
//                list.remove(i);
            }else{
                disList.add(list.get(i));
                map.put(list.get(i),"yes");
            }
        }

        for (String str:disList){
            System.out.println(str);
        }



    }
}
