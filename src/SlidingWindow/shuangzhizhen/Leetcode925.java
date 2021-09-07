package SlidingWindow.shuangzhizhen;

public class Leetcode925 {
    static class Solution {
        public boolean isLongPressedName(String name, String typed) {
            int npoint =0,tpoint=0;
            while (tpoint<typed.length()){
                if (npoint<name.length() && name.charAt(npoint) == typed.charAt(tpoint)){
                    npoint++;
                    tpoint++;
                }else if (tpoint>0 && typed.charAt(tpoint) == typed.charAt(tpoint-1)){
                    tpoint++;
                }else {
                    return false;
                }
            }
            return npoint == name.length();
        }
    }

    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleex";
        Solution solution = new Solution();
        System.out.println(solution.isLongPressedName(name,typed));
    }
}
