package com.bgs.Login.array;


import java.util.HashMap;
import java.util.Map;

public class MyArrayList<E> {

    int size = 0;
    Object[] data = null;
    Object[] newObj=null;
    public MyArrayList(){
        data = new Object[5];
    }
    public int size(){
        return size;
    }

    public void add(E object){
        if (size >= data.length){
            newObj = new Object[size*2];
            for (int i = 0 ; i<data.length;i++){
                newObj[i] = data[i];
            }
            data = newObj;
        }
        data[size] = object;
        size++;
    }
    public void insertAt(int index,E object){
        if (size >= data.length){
            newObj = new Object[size*2];
            for (int i = 0 ; i<data.length;i++){
                newObj[i] = data[i];
            }
            data = newObj;
        }
        if (index == size){
            data[size] = object;
        }else {
            for (int i = size;i>index;i--){
//                if (i == index) break;
                data[i] = data[i-1];
            }
            data[index] = object;
        }
        size++;
    }

    public E get(int index){
        E object = null;
        if (index >= data.length){
            object = null;
        }else {
            object = (E) data[index];
        }
        return object;
    }

    public void remove(int index){
        for (int i = index; i <size ; i++) {
            data[i] = data[i+1];
        }
        size--;
    }

    public int getMin(){
        int num = (int) data[0];
        for (int i = 0; i <size ; i++) {
            int dataNum = (int) data[i];
            if (dataNum<num){
                num = dataNum;
            }
        }
        return num;
    }
    public int getMax(){
        int num = (int) data[0];
        for (int i = 0; i <size ; i++) {
            int dataNum = (int) data[i];
            if (dataNum>num){
                num = dataNum;
            }
        }
        return num;
    }

    public void  arrayList(){
        int num;
        for (int i=0;i<size-1;i++){
            for(int j=0;j<size-i-1;j++){
                if((int)data[j+1]<(int)data[j]){
                    num= (int) data[j];
                    data[j]=data[j+1];
                    data[j+1]=num;
                }
            }
        }
    }




    public static void main(String[] args) {

        MyArrayList<Integer> myList = new MyArrayList();
        for (int i = 0; i <30 ; i++) {
            myList.add(i);
        }
        myList.add(120);

        myList.insertAt(3,130);
//        myList.remove(95);
        System.out.println(myList.size());
       for (int i = 0; i < myList.size(); i++) {
            int a = myList.get(i);
            System.out.print(myList.get(i)+",");
        }
        System.out.println();
        int minNum = myList.getMin();

        System.out.println("最小值："+minNum);
        int maxNum = myList.getMax();
        System.out.println("最大值："+maxNum);

        MyArrayList<Shop1> list1 = new MyArrayList<Shop1>();
        list1.add(new Shop1(1,"iphone"));
        list1.add(new Shop1(2,"ipad"));
        list1.add(new Shop1(2,"ipad1"));
        list1.add(new Shop1(3,"thinkpad"));
        list1.add(new Shop1(3,"thinkpad1"));

        MyArrayList<Shop2> list2 = new MyArrayList<Shop2>();
        list2.add(new Shop2(1,"手机"));
        list2.add(new Shop2(2,"平板电脑"));
        list2.add(new Shop2(3,"笔记本电脑"));

        MyArrayList<Shop3> list3 = new MyArrayList<Shop3>();
        int a = 1;
        for (int i = 0; i < list2.size() ; i++) {
            Shop2 shop2 = list2.get(i);
            for (int j = 0; j < list1.size(); j++) {
                Shop1 shop1 = list1.get(j);
                if (shop1.getType() == shop2.getId()){
                    list3.add(new Shop3(a,shop2.getShopCname(),shop1.getShopEname()));
                    a++;
                }
            }
        }
        for (int i = 0; i < list3.size() ; i++) {
            Shop3 shop3 = list3.get(i);
            System.out.println(shop3.getId()+"-"+shop3.getShopEname()+"-"+shop3.getShopCname());
        }

        Map<Integer,Shop2> map = new HashMap<>();
        map.put(1,new Shop2(1,"手机"));
        map.put(2,new Shop2(2,"平板电脑"));
        map.put(3,new Shop2(3,"笔记本电脑"));

        MyArrayList<Shop3> list4 = new MyArrayList<Shop3>();

        for (int i = 0; i < list1.size() ; i++) {
            list4.add(new Shop3(i+1,list1.get(i).getShopEname(),map.get(list1.get(i).getType()).getShopCname()));
        }
        System.out.println("list4");
        for (int i = 0; i <list4.size() ; i++) {
            Shop3 s = list4.get(i);
            System.out.println(s.getId()+"-"+s.getShopCname()+"-"+s.getShopEname());
        }




    }


}
