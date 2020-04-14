package com.likelxl.example.algorithmdemo;

import com.alibaba.fastjson.JSON;
import net.minidev.json.JSONUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class test {
    public static void main(String[] args) {
//        yihuoArr(new int []{1,2,3});
//        testHash();
        findDate(new int []{1,2,1,2,3});
    }

    public static void findDate(int[] arr){
        HashMap<Integer ,Integer > map = new HashMap<>();
        for (int i = 0;i < arr.length;i++){
            if(map.get(arr[i]) == null){
                map.put(arr[i],i);
            }else {
                map.remove(arr[i]);
            }
        }
        System.out.println(JSON.toJSONString(map));
    }

    public static void yihuoArr(int[] intArr){
        int currentIndex = 0;
        while (currentIndex<intArr.length/2){
            exchange(intArr,currentIndex);
            currentIndex++;
        }
        for (int c : intArr){
            System.out.println(c);
        }
    }

    public static void exchange(int[] intArr,int currentIndex){
        intArr[currentIndex] =intArr[currentIndex] ^ intArr[intArr.length-1-currentIndex];
        intArr[intArr.length-1-currentIndex] = intArr[intArr.length-1-currentIndex] ^intArr[currentIndex];
        intArr[currentIndex]= intArr[currentIndex] ^intArr[intArr.length-1-currentIndex];
    }
    public static void yihuo(){
        int n1=3;
        int n2=3;
        n1 ^= n2;
        System.out.println("n1 : "+ n1);
        n2 ^= n1;
        System.out.println("n2 : "+ n2);
        n1 ^= n2;
        System.out.println("n1 : "+ n1);
        System.out.println("n2 : "+ n2);
    }

    public static void testHash(){
        String empty = "";
        System.out.println("empty ‘s hash is : "+ empty.hashCode());
        String str_1 = "1";
        System.out.println("1 ‘s hash is : "+ str_1.hashCode());
        String str_11 = "11";
        System.out.println("11 ‘s hash is : "+ str_11.hashCode());
    }

    @Test
    public  void testMap(){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int i = 0;
        System.gc();
        long start = Runtime.getRuntime().freeMemory();
        while (i< 1){
            hashMap.put(i,i);
            i++;
        }
        System.gc();
        long end = Runtime.getRuntime().freeMemory();
        System.out.printf("内存占用: %s",end-start);
    }
}
