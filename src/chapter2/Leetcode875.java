package chapter2;

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

    public static void main(String[] args) {
        int[] piles = {332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        int H =823855818;
        System.out.println(minEatingSpeed(piles,H));
    }
}
