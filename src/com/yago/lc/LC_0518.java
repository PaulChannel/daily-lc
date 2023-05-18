package com.yago.lc;

public class LC_0518 {

    public static void main(String[] args) {
        LC_0518 lc0518 = new LC_0518();
        System.out.println(lc0518.quickMul(2.0, 10));
    }

    public double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double ans = 1.0;
        double contribute = x;
        while (n > 0) {
            if (x % 2 != 0) {
                ans *= contribute;
            }
            contribute *= contribute;
            n /= 2;
        }
        return ans;
    }
}
