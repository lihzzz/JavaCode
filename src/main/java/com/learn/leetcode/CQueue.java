package com.learn.leetcode;

import java.util.Stack;

/**
 * @author lihzz
 * @version 1.0
 * @date 2022/12/1 23:45
 */
public class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;


    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty()) {
            return -1;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int value = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return value;
    }
}
