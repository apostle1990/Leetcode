package BinarySearch;

public class LCP12 {
    static boolean Check(int limit, int[] cost, int day){
        int useday=1, totaltime=0, maxtime=0;
        for (int j : cost) {
            int nexttime = Math.min(maxtime, j);
            if (nexttime + totaltime <= limit) {
                totaltime += nexttime;
                maxtime = Math.max(maxtime, j);
            } else {
                ++useday;
                totaltime = 0;
                maxtime = j;
            }
        }
        return (useday <= day);
    }
    static public int minTime(int[] time, int m) {
        int left=0 , right=0, middle;
        for (int j : time) {
            right += j;
        }
        while (left <= right){
            middle = (left + right) >>1;
            if(Check(middle,time,m)) right = middle -1;
            else left = middle +1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] time = {1,2,3,3};
        int m =2;
        System.out.println(minTime(time,m));
    }
}
