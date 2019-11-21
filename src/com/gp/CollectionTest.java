package com.gp;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        //定义一个集合，在其中插入5个人，并且他们放入的顺序和取出的顺序一致 ArrayList底层数组实现
        List list = new ArrayList();
        //在一个集合中添加5个元素
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu3");
        list.add("wangwu2");
        list.add("wangwu1");

        //从集合中分别拿出5个元素
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }

        //LinkedList 链表实现
        List linkedlist = new LinkedList();
        linkedlist.add("zhangsan1");
        linkedlist.add("zhangsan2");
        linkedlist.add("zhangsan3");
        linkedlist.add("zhangsan4");
        linkedlist.add("zhangsan5");

        //从集合中分别拿出5个元素
        for (int i = 0; i < linkedlist.size() ; i++) {
            System.out.println(linkedlist.get(i));
        }

        setTest();
    }

    public static void setTest(){
        //Set集合中不能放置重复的对象
        Set set = new HashSet();
        set.add("zhangsan");
        set.add("zhangsan");
        set.add("zhangsan");
        set.add("zhangsan");
        set.add("zhangsan");
        set.add("lisi");
        set.add("lisi");

        for (Object o : set) {
            System.out.println("o="+o);
        }
    }
}
