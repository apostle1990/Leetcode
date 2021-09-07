package Stack;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode1306 {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) return true;
        int len = arr.length;
        boolean[] used = new boolean[len];
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(start);
        used[start] = true;
        while (!deque.isEmpty()){
            int u = deque.pollFirst();
            if (u + arr[u] < len && !used[u+ arr[u]]){
                if (arr[u + arr[u]] ==0) return true;
                deque.addLast(u + arr[u]);
                used[u + arr[u]] = true;
            }
            if (u - arr[u] >=0 && !used[u - arr[u]]){
                if (arr[u - arr[u]] ==0) return true;
                deque.addLast(u - arr[u]);
                used[u - arr[u]] = true;
            }
        }
        return false;
    }
}
