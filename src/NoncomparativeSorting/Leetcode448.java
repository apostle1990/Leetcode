package NoncomparativeSorting;

import java.util.ArrayList;
import java.util.List;

public class Leetcode448 {
    static public List<Integer> findDisappearedNumber(int[] nums) {
        int len = nums.length;
        for (int num:nums){
            int x = (num - 1) % len;
            nums[x] +=len;
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<len; i++){
            if (nums[i] <=len){
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumber(nums));
    }
}
