package SlidingWindow.huadongchuangkou;

import java.util.HashMap;

public class Leetcode3 {
    //3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        int num=1;
        int max=1;
        String str = s.substring(0,1);
        for (int i=1;i<s.length();i++){
            max = Math.max(max,num);
            int point = str.indexOf(s.substring(i,i+1));//此元素在字符串中的位置
            if (point==-1){
                str = str.concat(s.substring(i,i+1));
                num++;
            }
            else {
                str = str.substring(point+1);
                str = str.concat(s.substring(i,i+1));
                num = num - point;
            }
        }
        max = Math.max(max,num);
        return max;
    }
    public int lengthOfLongestSubstring1(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();
        String s = "aabaab!bb";
        System.out.println(leetcode3.lengthOfLongestSubstring(s));
    }
}
