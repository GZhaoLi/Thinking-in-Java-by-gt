package com.leetcode;

/**
 * @author chappyzhao
 */
public class CuttingRope {
    public static int cuttingRope(int n) {
        /*
        dp 思路：剪成两段最大的乘积是 f(n) = f(x) * f(n-x),f(2) 虽然等于1，但在计算的时候只能等于2，不能再拆分下去
        也就是在 dp 计算的时候，f(x)的最小值只能是x，不能小于x，而在x>4的时候不需要特殊计算
         */
        int[] f = new int[n + 1];
        if (n <= 3) {
            return Math.max(n - 1, 1);
        }
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i-1; j++) {
                f[i] = Math.max(f[i], f[j] * f[i - j]);
            }
        }
        return f[n];
    }

    public static void main(String[] args) {

        System.out.println(cuttingRope(10));
    }
}
