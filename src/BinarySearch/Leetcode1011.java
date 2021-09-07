package BinarySearch;

public class Leetcode1011 {
    static boolean Check(int limit, int[] cost,int day){
        int useday =1,totalweights=0;
        for (int i :cost){
            if (i > limit) return false;
            if (totalweights + i <= limit){
                totalweights += i;
            }else {
                useday++;
                totalweights =i;
            }
        }
        return (useday <= day);
    }
    static public int shipWithinDays(int[] weights, int D) {
        int left =0,right=1,middle;
        for (int i:weights){
            right += i;
        }
        while (left <= right){
            middle = (right + left)>>1;
            if (Check(middle, weights, D)) right = middle-1;
            else left = middle +1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(shipWithinDays(weights,D));
    }
}
