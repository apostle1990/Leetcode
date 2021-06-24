package chapter13;

public class Leetcode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i=1;i<=len1; i++){
            for (int j=1; j<=len2; j++){
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Leetcode1143 leetcode1143 = new Leetcode1143();
        String text1 = "abcde";
        String text2 = "ace";
        int res = leetcode1143.longestCommonSubsequence(text1,text2);
        System.out.println(res);
    }
}
