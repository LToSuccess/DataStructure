package com.hlx.linkList;

import java.util.Stack;

/**
 * 演示栈Stack的使用
 *
 * @author hlx
 * @create 2020-09-19 11:26
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");
        //出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());   //pop就是将栈顶的数据取出
        }
    }
}
