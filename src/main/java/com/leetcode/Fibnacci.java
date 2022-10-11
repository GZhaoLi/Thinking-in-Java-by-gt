package com.leetcode;

/**
 * @author chappyzhao
 */
public class Fibnacci {
    public static int fib(int n) {

        if(n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    public static int numWays(int n) {
        if(n<0) {
            return 0;
        }
        int[] num = new int[n+1];
        num[0] = 1;
        num[1] = 1;
        for(int i=2;i<=n;i++){
            num[i] = num[i-1]+num[i-2];
            num[i] %= 1000000007;
        }
        return num[n];
    }
    public static void main(String[] args) {

        System.out.println(fib(45));
        System.out.println(numWays(3));
    }
}
