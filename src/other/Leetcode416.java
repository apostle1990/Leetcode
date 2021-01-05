package other;

import java.util.Stack;

public class Leetcode416 {
public boolean canPartition(int[] nums) {
    int n = nums.length;
    if(n<2){
        return false;
    }
    int sum=0,maxnum=0;
    for(int num:nums){
        sum+=num;
        maxnum = Math.max(maxnum,num);
    }
    if (sum%2!=0){
        return false;
    }
    int target = sum/2;
    if(maxnum>target){
        return false;
    }else if (maxnum == target) return true;
    int i=n-1;
    sum=0;
    Stack temp=new Stack<Integer>();
    Stack change=new Stack<Integer>();
    while (i>=0){
        int tar = sum + nums[i];
        if (tar<=target){
            if (i>0 && nums[i]!=nums[i-1]) {
                change.push(i - 1);
                temp.push(sum);
            }
            sum = tar;
        }
        if (sum == target) return true;
        i--;
        if (i<0) {
            if (!change.empty()){
                i=(int)change.pop();
                sum = (int)temp.pop();
            }
        }
    }
    return false;
}
    public static void main(String[] args) {

        //int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
        int[] nums = {88,29,42,97,15,74,16,52,59,28,86,35,50,99,50,94,46,74,16,94,52,24,90,60,37,68,85,74,96,22,16,50,11,70,39,68,97,11,46,27,44,78,35,26,84,18,93,77,98,47,20,74,100,95,64,75,69,43,16,20,79,30,45,9,69,9,74,98,16,6,13,72,53,61,70,71,58,80,64,21,14,27,1,45,75,28,33,5,45,89,99,54,83,58,96,19,25,15,48};
        Leetcode416 leetcode416 = new Leetcode416();
        System.out.println(leetcode416.canPartition(nums));
    }
}
