package com.learn.interview;

import java.util.*;

//输入n个整数，找出其中最大的k个数。例如输入4、 5、 1、 6、 2、 7、 3、 8这8个数字，则最大的4个数字是5、 6、 7、 8。
public class Bigo {

    public List<Integer> kNumber(int[] nums,int k){
        List<Integer> res = new LinkedList<>();

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        while (k>0){
            res.add(queue.poll());
            k--;
        }
        System.out.println(res);
        return res;
    }

    //建立大顶堆
    public void heapInsert(int[] arr,int index){
        // 将当前节点和父节点进行比较，如果大于父节点则交换
        while(arr[index] > arr[(index - 1)/2]){
            swap(arr,index,(index - 1) / 2);
            // 交换之后，继续向上比较
            index = (index - 1)/2;
        }
    }



    public void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Bigo bigo = new Bigo();
        int[] nums = new int[]{4,5,1,6,2,7,3,8};
        for (int i = 0; i < nums.length; i++) {
            bigo.heapInsert(nums,i);
        }
    }

}
