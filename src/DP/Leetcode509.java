package DP;

public class Leetcode509 {
    //递归时间复杂度为O(n2)
    public int fib(int n) {
        if(n<2) return n;
        int p =0,q=0,r=1;
        for (int i=2; i<=n; i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
