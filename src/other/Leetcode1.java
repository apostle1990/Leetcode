package other;

import java.util.HashMap;

//两数之和的下标
public class Leetcode1 {

    //暴力破解
    public int[] twosum(int[] nums, int target){
        int  n = nums.length;
        for (int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    //hashmap
    public int[] twosumhash(int[] nums, int target){
        int  n = nums.length;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0; i<n; i++){
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target-nums[i]),i};
            }
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,6,7,8,12,23,234};
        int target = 35;
        Leetcode1 leetcode1 = new Leetcode1();
        //int[] result = leetcode1.twosum(nums,target);
        int[] result = leetcode1.twosumhash(nums,target);
        if (result.length !=2){
            System.out.println("未查询到");
        }else{
            for(int i:result){
                System.out.println(i);
            }
        }
    }
}