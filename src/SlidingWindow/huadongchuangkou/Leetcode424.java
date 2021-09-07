package SlidingWindow.huadongchuangkou;

public class Leetcode424 {
    class Solution {
        public int characterReplacement(String s, int k) {
            int[] map = new int[26];
            if (s == null){
                return 0;
            }
            char[] chars = s.toCharArray();
            int left=0;
            int right =0;
            int historymax = 0; //滑动窗口内相同字母出现次数的历史最大值
            for (right=0;right<chars.length;right++){
                int index = chars[right] - 'A';
                map[index]++;
                historymax = Math.max(historymax,map[index]);
                if (right - left+1 > historymax +k){
                    map[chars[left] - 'A']--;
                    left++;
                }
            }
            return chars.length - left;
        }
    }
}
