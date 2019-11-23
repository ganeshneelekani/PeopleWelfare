package com.peoplewelfare.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SampleClass {

    public static void main(String[] args) {

        String s= "PP00002".substring(2);
        System.out.println(s);


        List list=new ArrayList();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(1);
        System.out.println(Collections.frequency(list,1));

    }
}
