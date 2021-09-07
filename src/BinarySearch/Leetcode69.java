package BinarySearch;

public class Leetcode69 {
    public static int mySqrt(int x) {
     int l = 0, r = x, result = -1;
     while (l<=r){
         int mid = l + (r - l) /2;
         if ((long) mid * mid <= x){
             result = mid;
             l = mid +1;
         }else {
             r = mid -1;
         }
     }
     return result;
    }

    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(mySqrt(x));
    }
}
