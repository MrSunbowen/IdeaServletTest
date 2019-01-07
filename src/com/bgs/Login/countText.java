package com.bgs.Login;

import java.io.*;
import java.util.*;

public class countText {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaUI\\test\\student.txt"));

        String line;
        List<String> list = new ArrayList<>();
        while ((line = br.readLine())!=null){
            list.add(line);
        }

        Map<String,Integer> map = new HashMap<>();

        for (int i = 0; i < list.size() ; i++) {
            String[] str = list.get(i).split(",");
            int num = 1;
            boolean bool = map.containsKey(str[1]);
            if (bool){
                int cou = map.get(str[1]);
                map.put(str[1],cou+1);
            }else{
                map.put(str[1],num);
            }
        }
        List<Map.Entry<String, Integer>> ListMap = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(ListMap, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo( o1.getValue());
            }
        });

        for (int i = 0; i < ListMap.size(); i++) {
            String key = ListMap.get(i).getKey();
            int value = ListMap.get(i).getValue();
            System.out.println(key +" -- "+ value);
        }



        /* String line;
        List<String> list = new ArrayList<>();
        while ((line = br.readLine())!=null){
            list.add(line);
        }

        String[] strName = new String[list.size()];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < list.size() ; i++) {
            String[] str = list.get(i).split(",");
            strName[i] = str[1];
            set.add(str[1]);
        }

        List<User> lists=new ArrayList<>();
        for (String str:set){
            int num = 0 ;
            for(String strArray : strName){
                if (str.equals(strArray)) num++;
            }
            lists.add(new User(str,num));
        }

        Collections.sort(lists, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.num-o1.num;
            }
        });

        for (User user : lists){
            System.out.println(user.getName()+"-"+user.getNum());
        }*/

    }

    static class User {
        private String name;
        private int num;

        public User(String name, int num) {
            this.name = name;
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
