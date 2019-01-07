package com.bgs.Login.link;

public class List {

    int size;
    Node headNode;
    Node lastNode;

    public int size(){
        return size;
    }

    public void add(Object object){
        if (headNode == null){
            Node node = new Node(object,null,null);
            headNode = node;
            lastNode = headNode;
        }else {
            Node node = new Node(object,null,null);
            lastNode.next = node;
            lastNode = node;
            if (size() == 1){
                lastNode.up = headNode;
            }else {
                Node node1 = headNode;
                for (int i = 0; i < size()-1 ; i++) {
                    node1 = node1.next;
                }
                lastNode.up = node1 ;
            }
        }
        size++;
    }

    public Node get(int index){
        if (headNode==null){
            throw  new RuntimeException("集合为空");
        }else{
            Node node;
            if (index == 0){
                node = headNode;
            }else if (index == size-1){
                node = lastNode;
            }else {
                node = headNode;
                for (int i = 0; i < index ; i++) {
                    node = node.next;
                }
            }
            return node;
        }
    }

    public void remove(int index){
        Node node = get(index);
        if (index == size()-1){
            Node shang = node.up;
            shang.next = null;
            size--;
        }else if (index == 0){
            headNode = node.next;
            size--;
        } else {
            if (node != null) {
                Node shang = node.up;
                Node xia = node.next;
                shang.next = xia;
                xia.up = shang;
                size--;
            }
        }
    }

    public static void main(String[] args) {

        List list= new List();
        list.add("aa");
        list.add(22);
        list.add(new User(1,"aaaaa"));
        list.add("dd");

       list.remove(0);
       System.out.println(list.size());
        for (int i = 0; i <list.size() ; i++) {
            Node node = list.get(i);
            System.out.println(node.getValue());
        }
//       Node node = list.get(1);
//       System.out.println(node==null?"node为空":"node有值"+node.getValue());
        /*User user = (User) list.get(2).getValue();
        System.out.println(user.getName());*/
    }

   static class User{
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

       public int getId() {
           return id;
       }

       public void setId(int id) {
           this.id = id;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }
   }
}
