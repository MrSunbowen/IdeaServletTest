package com.bgs.Login.bitset;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class BitSetTest {

    public static void main(String[] args) {
        BitSet bs = new BitSet(10);
        bs.set(1);
        bs.set(2);
        bs.set(3);
        bs.set(4);
        bs.clear(4);//删除
        System.out.println(bs.cardinality());//返回此 BitSet 中设置为 true 的位数。
        System.out.println(bs.size());
        System.out.println(bs.toString());
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(1,"b");
        System.out.println(map.get(1));
        for (Integer str : map.keySet()){
            System.out.println(map.get(str));
        }
    }
}
