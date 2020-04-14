package com.likelxl.example.algorithmdemo;

import java.util.Comparator;
public class Java8Tester {

    public static void main(String[] args) {
        int num = 1;// 这里也可以申明为final 类型 不申明也没问题，非函数参数的外部变量，在函数体内不能被修改（赋值）
        Converter<Integer, String> s = (param) ->{  System.out.println(String.valueOf(param + num));};
        s.convert(2);  // 输出结果为 3
        // 在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
        String first = "";
        Comparator<String> comparator = (first2, second) -> Integer.compare(first.length(), second.length());

    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }
}
