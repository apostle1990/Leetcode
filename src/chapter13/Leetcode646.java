package chapter13;

import java.util.Arrays;

public class Leetcode646 {
    //贪心算法
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[0]-b[0]);
        int cur = Integer.MIN_VALUE, ans =0;
        for (int[] pair:pairs){
            if (cur<pair[0]){
                cur=pair[1];
                ans++;
            }
        }
        return ans;
    }
    //动态规划
    public int findLongestChain1(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int N = pairs.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int j = 1; j < N; ++j) {
            for (int i = 0; i < j; ++i) {
                if (pairs[i][1] < pairs[j][0])
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            }
        }

        int ans = 0;
        for (int x: dp) if (x > ans) ans = x;
        return ans;
    }

    public static void main(String[] args) {
        Leetcode646 leetcode646 = new Leetcode646();
        int[][] pairs ={{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}};
        int res = leetcode646.findLongestChain(pairs);
        System.out.println(res);
    }
}
