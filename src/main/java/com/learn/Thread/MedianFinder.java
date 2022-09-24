package com.learn.Thread;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    public PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();
    public PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(queue1.size() == queue2.size()){
            queue1.offer(num);
            queue2.offer(queue1.poll());
        }
        else{
            queue2.offer(num);
            queue1.offer(queue2.poll());
        }
    }

    public double findMedian() {
        return queue1.size() == queue2.size() ? (queue2.peek() + queue1.peek()) / 2.0 :queue1.peek();
    }

    public static void main(String[] args) {
        int a = 5,b = 6;
        int ans = 0;
        for (; b != 0 ; b >>= 1) {
            if((b & 1) == 1){
                ans += a;
            }
            a <<= 1;
        }
        System.out.println(ans);
    }
}


