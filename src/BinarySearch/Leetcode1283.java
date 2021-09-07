package BinarySearch;

public class Leetcode1283 {
    public static int smallestDivisor(int[] nums, int threshold) {
        int maxval = 1;
        for (int num : nums){
            maxval = Math.max(maxval,num);//获得数组最大值
        }
        int left=1 , right=maxval;
        while (left<right){
            int mid = left +(right - left) /2;
            int sum = suma(nums,mid);
            if (sum>threshold){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    public static int suma(int[] nums,int mid){
        int sum=0;
        for (int num:nums){
            sum += num/mid;
            if (num % mid != 0) {
                sum++;
            }
        }
        return sum;
    }
}
