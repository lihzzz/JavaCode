package com.learn.leetcode;

import java.util.Objects;

public class Solution {

    /**
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 0) {
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }
        return nums;
    }


    /**
     * 数组排序
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        // 1. 输入输出类型：输入数组，输出数组
        if (Objects.isNull(nums) || nums.length == 0) {
            // 2. 输入edge case： null or empty
            return new int[0];
        }
        quickSortHelper(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 堆排序
     *
     * @param nums sort array
     */
    public void heapSortHelper(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            buildHeap(nums, i);
        }
        int size = nums.length;
        // 堆构建好后，0位置为root节点，也就是最大的节点（小顶堆为最小节点），放到最后，代表该位置已经排好序
        swap(nums, 0, --size);
        while (size > 0) {
            heapify(nums, 0, size);
            swap(nums, 0, --size);
        }
    }

    /**
     * 构建堆结构
     *
     * @param nums  sort array
     * @param index 堆节点索引
     */
    private void buildHeap(int[] nums, int index) {
        // 大顶堆 -> 每个节点和他的父节点进行比较，如果比父节点大则调换位置
        // 父节点位置: (index - 1) / 2;
        int parentIndex = (index - 1) / 2;
        while (parentIndex >= 0 && nums[parentIndex] < nums[index]) {
            swap(nums, parentIndex, index);
            // 比较之后，再判断父节点是否比父节点的父节点大，直到root
            index = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
    }

    /**
     * 堆排后，对修改的位置进行堆调整
     *
     * @param nums  sort array
     * @param index 调整的位置索引
     * @param size  当前待排序数组的大小
     */
    private void heapify(int[] nums, int index, int size) {
        // 节点左节点
        int left = 2 * index + 1;
        while (left < size) {
            // 从上往下遍历，直到叶子节点。因为修改后的节点位置为index
            // 需要判断该节点是否满足堆得要求，从上往下比较，需要把节点、左节点、右节点中最大的值放大节点上（小顶堆，则是最小的作为父节点）
            int largeIndex = left;
            if (left + 1 < size && nums[largeIndex] < nums[left + 1]) {
                largeIndex = left + 1;
            }
            if (nums[largeIndex] < nums[index]) {
                // 父节点都大于子节点，不需要往下遍历了，直接跳出
                break;
            }
            swap(nums, largeIndex, index);
            // 修改变更的节点index
            index = largeIndex;
            left = index * 2 + 1;
        }
    }

    /**
     * 快速排序
     *
     * @param nums       待排序数组
     * @param startIndex 排序起始位置
     * @param endIndex   排序结束位置
     */
    public void quickSortHelper(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        // 找哨兵值，每次遍历是的该值左边的值比它小，右边的值比他大
        int firstNum = nums[startIndex];
        int l = startIndex, r = endIndex;
        while (l < r) {
            // 从后往前找到第一个小于哨兵值的数，放到它的前面
            while (l < r && nums[r] >= firstNum) r--;
            nums[l] = nums[r];

            // 从前往后找到第一个大于哨兵值的数，放到它的后面
            while (l < r && nums[l] <= firstNum) l++;
            nums[r] = nums[l];
        }
        // 将哨兵值放到中间位置
        nums[l] = firstNum;
        // 排序左半边
        quickSortHelper(nums, startIndex, l - 1);
        // 排序右半边
        quickSortHelper(nums, l + 1, endIndex);
    }

    /**
     * 121 买卖股票的最佳时机
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int maxValue = 0;
        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (prices[i] < minNumber) {
                minNumber = prices[i];
            } else {
                maxValue = Math.max(prices[i] - minNumber, maxValue);
            }
        }
        return maxValue;
    }

    /**
     * 122. 买卖股票的最佳时机 II
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int maxValue = 0;
        int curNumber = prices[0];
        for (int i = 2; i < n; i++) {
            if (prices[i] > curNumber) {
                maxValue += prices[i] - curNumber;
                curNumber = prices[i];
            }
        }
        return maxValue;
    }

    /**
     * 123. 买卖股票的最佳时机 III
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int tradeCount = 2;
        // 记忆化搜索
        // 第一个参数：第i天
        // 第二个参数: 交易次数
        // 第三个参数: 是否持有股票
        int[][][] dp = new int[n][tradeCount + 1][2];

        // 初始化第0天数据
        for (int i = 0; i < 3; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        // 递推后面天数的数据
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= tradeCount; j++) {
                // 第i天过后手上没有股票
                if (j == 0) {
                    dp[i][j][0] = dp[i - 1][j][0];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                }
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        int maxValue = Math.max(dp[n - 1][0][0], dp[n - 1][1][0]);
        return Math.max(maxValue, dp[n - 1][2][0]);


        // 递归
//        return maxProfit3Helper(prices,0,0,0);

    }


    /**
     * 递归
     *
     * @param prices
     * @param i
     * @param hasStock 手上是否有股票
     * @param count    完整交易次数
     * @return
     */
    private int maxProfit3Helper(int[] prices, int i, int hasStock, int count) {
        if (i >= prices.length || (count >= 2) && (hasStock < 1)) {
            // 遍历结束 || 交易次数大于2并且手中没有股票
            return 0;
        }
        // 对于每一天，可以选择卖出股票 也可以选择买入股票
        if (hasStock >= 1) {
            // 手中有股票可以选择卖或者不卖
            return Math.max(prices[i] + maxProfit3Helper(prices, i + 1, 0, count), maxProfit3Helper(prices, i + 1, 1, count));
        }
        // 买或者不买
        return Math.max(-prices[i] + maxProfit3Helper(prices, i + 1, 1, count + 1), maxProfit3Helper(prices, i + 1, 0, count));
    }


    /**
     * 55. 跳跃游戏
     * https://leetcode.cn/problems/jump-game/
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxLocation = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxLocation) {
                // 当前位置不可达，不需要继续遍历下去
                break;
            }
            maxLocation = Math.max(maxLocation, i + nums[i]);
            if (maxLocation >= n - 1) {
                return true;
            }
        }
        return false;

    }


    /**
     * 交换数据的两个数的位置
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
