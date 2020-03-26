package com.likelxl.example.algorithmdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 快速排序实现
 *
 * */
public class QuickSortDemo {


    public static void main(String[] args) {
        List<Integer> sourceList = new ArrayList<Integer>();

        Random random = new Random();
        int i = 0;
        int size = 100;
        while (i< size){
            int num = random.nextInt(size)+1;
            sourceList.add(num);
            i++;
        }
        sortByFast(0,sourceList.size()-1,sourceList);
        System.out.println(sourceList);
    }

    public static void sortByFast(int left,int right,List<Integer> currentList){

        if(left>=right){
            return;
        }
        int i = left , j = right;
        int temp = currentList.get(left);
       while (i<j){
           while (temp <= currentList.get(j) &&i<j){
               j--;
           }
           while (temp >= currentList.get(i)&&i<j ){
               i++;
           }
           if(i<j) {
               int a = currentList.get(i);
               currentList.set(i, currentList.get(j));
               currentList.set(j, a);
           }
       }

       currentList.set(left,currentList.get(i));
       currentList.set(i,temp);

        sortByFast(left,j-1,currentList);
        sortByFast(j+1,right,currentList);
    }


}
