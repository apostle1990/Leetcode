package BinarySearch;

public class Leetcode1482 {
    static public int minDays(int[] bloomDay, int m, int k) {
        int left=bloomDay[1], right=bloomDay[1];
        for (int i :bloomDay){
            left = Math.min(left, i);
            right = Math.max(right,i);
        }
        int max = right;
        while (left <= right){
            int middle = (left + right) >>1;
            if (Check(bloomDay,m,k,middle)) right = middle-1;
            else left = middle +1;
        }
        if (left > max) return -1;
        return left;
    }
    static boolean Check(int[] bloomDay,int m,int k,int limit){
        int finishfollow=0, usefollow=0;
        for (int i:bloomDay){
            if (i <= limit){
                usefollow++;
                if (usefollow >=k){
                    finishfollow++;
                    usefollow=0;
                }
            }else {
                usefollow=0;
            }
        }
        return (finishfollow >= m);
    }

    public static void main(String[] args) {
        int[] boolmDay = {1,10,3,10,2};
        int m =3, k=1;
        System.out.println(minDays(boolmDay,m,k));
    }
}
