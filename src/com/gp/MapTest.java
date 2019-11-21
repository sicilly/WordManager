package com.gp;

import org.junit.Test;

import java.util.*;

public class MapTest {
    @Test
    public void testMapAdd(){
        //在map中每次放入一个键值对
        Map map = new HashMap();
        map.put("name","zhangsan");
        map.put("age",30);
        map.put("address","shenzhen");

        //从Map中获取元素
        Object name = map.get("name");
        System.out.println("name = " + name);

        Object address = map.get("address");
        System.out.println("address.toString().toUpperCase() = " + address.toString().toUpperCase());
    }

    @Test
    public void testMapIter(){
        //Map的遍历
        Map map = new HashMap();
        map.put("name","zhangsan");
        map.put("age",30);
        map.put("address","shenzhen");

        //获取map中所有key的集合
        Set set = map.keySet();

        //Map的遍历，通过key去寻找value
        for (Object o : set) {
            System.out.println("key = " + o);
            System.out.println("value = " + map.get(o));
        }

        //获取Map中的values
        Collection values=map.values();
        for (Object value : values) {
            System.out.println("value = " + value);
        }
    }

    @Test
    public void testSort() {
        //如果要让对象快速的排序，那么默认把对象放入TreeMap即可，要实现比较接口才可
        Map map = new TreeMap();
        map.put("name9", "zhangsan");
        map.put("name3", "zhangsan");
        map.put("name4", "zhangsan");
        map.put("name6", "zhangsan");
        map.put("name5", "zhangsan");
        map.put("name1", "zhangsan");
        map.put("name7", "zhangsan");
        map.put("name10", "zhangsan");

        for (Object o : map.keySet()) {
            System.out.println("o = " + o);
        }

    }


}
