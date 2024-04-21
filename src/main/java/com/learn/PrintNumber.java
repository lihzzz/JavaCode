package com.learn;

import java.math.BigDecimal;


public class PrintNumber {

    public static void main(String[] args) {
        BigDecimal curSum = new BigDecimal(1);
        BigDecimal res = new BigDecimal(0);
        for (int i = 2; i < 100; i++) {
            curSum = curSum.multiply(BigDecimal.valueOf(i));
            if (isPrimeNumber(i)) {
                res = res.add(curSum);
            }
        }
        System.out.println(res.toString());
    }

    /**
     * 判断一个数是否是素数
     *
     * @param n
     * @return
     */
    public static boolean isPrimeNumber(int n) {
        if (n < 2) return false;
        int end = (int) Math.sqrt(n);
        for (int i = 2; i < end; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
