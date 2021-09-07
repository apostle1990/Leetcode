package BinarySearch;

import java.util.Arrays;

public class Leetcode1552 {
    static public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length -1 ],ans =-1;
        while (left <=right){
            int mid = (left + right) /2;
            if(check(mid, position, m)){
                ans = mid;
                left = mid +1;
            }else {
                right = mid -1;
            }
        }
        return ans;
    }
    static boolean check(int x,int[] position,int m){
        int pre = position[0], cnt=1;
        for(int i:position){
            if(i - pre >=x){
                pre = i;
                cnt +=1;
            }
        }
        return (cnt >= m);
    }

    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;
        System.out.println(maxDistance(position,m));
    }
}
