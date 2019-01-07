package com.bgs.Login.array;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisArray {
    public static void main(String[] args) {

        List<User> list = new ArrayList<>();
        list.add(new User("张三","安徽",90));
        list.add(new User("李四","安徽",80));
        list.add(new User("王五","安徽",70));
        list.add(new User("张三","安徽",90));
        list.add(new User("李四","安徽",80));

        Map<String,User> map = new HashMap<>();
        for (int i = 0; i < list.size() ; i++) {
            User user = list.get(i);
            boolean bool = map.containsKey(user.toString());
            if (bool){
                System.out.println("重复");
            }else {
                map.put(user.toString(),user);
            }
        }

        for (Map.Entry<String,User> m:map.entrySet()){
            User user = m.getValue();
            System.out.println(user.getName()+"-"+user.getHome()+"-"+user.getNum());
        }



    }

    static class User {
        private String name;
        private String home;
        private int num;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", home='" + home + '\'' +
                    ", num=" + num +
                    '}';
        }

        public User(String name, String home, int num) {
            this.name = name;
            this.home = home;
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
