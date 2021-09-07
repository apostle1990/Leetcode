package BinarySearch;

public class Leetcode875 {
    public static int minEatingSpeed(int[] piles, int H) {
        int maxval=0;
        for (int i:piles){
            maxval = Math.max(i,maxval);
        }
        int left=1,right=maxval;
        if (H>right) return 1;
        while (left < right){
            int mid = left + (right - left) /2;
            int sum = suma(piles,mid);
            if (sum > H){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }
    public static int suma(int[] piles,int mid){
        int sum=0;
        for (int num:piles){
            sum += num/mid;
            if (num % mid != 0) {
                sum++;
            }
        }
        return sum;
    }
}
