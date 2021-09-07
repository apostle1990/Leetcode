package Stack;

//接雨水
public class Leetcode42 {
    public int trap(int[] height) {
        int len = height.length;
        int area = 0;
        for (int i =1; i<= len-1; i++){
            int max_left =0, max_right = 0;
            for (int j =i; j>=0; j--){
                max_left = Math.max(max_left, height[j]);
            }
            for (int j=i; j<len; j++){
                max_right = Math.max(max_right, height[j]);
            }
            area += Math.min(max_left,max_right) - height[i];
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Leetcode42 leetcode42 = new Leetcode42();
        int area = leetcode42.trap(height);
        System.out.println(area);
    }
}
