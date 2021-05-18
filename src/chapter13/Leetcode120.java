package chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len+1][len+1];
        for (int i=len-1; i>=0; i--){
            for (int j=0; j<=i; j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2,3));
        triangle.add(Arrays.asList(1,-1,-3));
        Leetcode120 leetcode120 = new Leetcode120();
        int res = leetcode120.minimumTotal(triangle);
        System.out.println(res);
    }
}
