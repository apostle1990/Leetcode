package DP;

public class Leetcode91 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] f = new int[len + 1];
        f[0] = 1;
        for (int j=1;j<=len;j++){
            if (s.charAt(j-1)!='0'){
                f[j] += f[j-1];
            }
            if (j>1 && s.charAt(j-2)!='0' && ((s.charAt(j-2)-'0')*10+(s.charAt(j-1)-'0'))<=26){
                f[j] += f[j-2];
            }
        }
        return f[len];
    }
}
