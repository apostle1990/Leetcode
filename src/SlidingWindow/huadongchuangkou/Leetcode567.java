package SlidingWindow.huadongchuangkou;

public class Leetcode567 {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length()>s2.length()) return false;
            int[] chs1 = new int[26];
            int[] chs2 = new int[26];
            for (int i=0;i<s1.length();i++){
                chs1[s1.charAt(i) - 'a']++;
                chs2[s2.charAt(i) - 'a']++;
            }
            int count =0;
            for (int i=0;i<26;i++){
                if (chs1[i]==chs2[i]){
                    count++;
                }
            }
            for (int i=0;i<s2.length()-s1.length();i++){
                int r=s2.charAt(i+s1.length())-'a';
                int j=s2.charAt(i)-'a';
                if (count==26) return true;
                chs2[r]++;
                if (chs2[r]==chs1[r]) count++;
                else if (chs2[r] == chs1[r]+1) count--;
                chs2[j]--;
                if (chs2[j]==chs1[j]) count++;
                else if (chs2[j] == chs1[j]-1) count--;
            }
            return count==26;
        }
    }
}
