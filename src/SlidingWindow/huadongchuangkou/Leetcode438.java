package SlidingWindow.huadongchuangkou;

import java.util.ArrayList;
import java.util.List;

public class Leetcode438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int lenp = p.length();
        int lens = s.length();
        if (lens < lenp) return res;

        char[] chs = new char[26];
        char[] chp = new char[26];
        int ch;
        for (int i=0; i<lenp;i++){
            ch = p.charAt(i) -'a';
            chp[ch]++;
        }

        int left=0;
        for (int i=0; i<lens;i++){
            ch = s.charAt(i) -'a';
            chs[ch]++;
            while (chs[ch]>chp[ch]){
                int curLeft = s.charAt(left) - 'a';
                chs[curLeft]--;
                left++;
            }
            if (i-left+1==lenp){
                res.add(left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abacbabc";
        String  p = "abc";
        List<Integer> res = findAnagrams(s,p);
        System.out.println(res);
    }
}
