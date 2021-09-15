package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode56 {
    public int[][] merge(int[][] intervals) {

        int len = intervals.length;
        if (len <2) return intervals;

        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i=1;i<len;i++){
            int[] ints = intervals[i];

            int[] peek = res.get(res.size()-1);

            if (peek[1]>=ints[0]){
                peek[1] = Math.max(peek[1], ints[1]);

            }else {
                res.add(ints);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
