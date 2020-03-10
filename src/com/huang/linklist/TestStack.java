package com.huang.linklist;

import java.util.Stack;

/*
 * 演示栈的基本使用
 * */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("1");
        stack.add("2");
        stack.add("3");
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
