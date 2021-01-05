package other;

public class Leetcode27 {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int i=0;
        for (int j=1;j<nums.length;j++){
            if (nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
}
