package PriorityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Leetocde347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums){
            hashMap.put(i, hashMap.getOrDefault(i, 0) +1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> hashMap.get(y) - hashMap.get(x));
        priorityQueue.addAll(hashMap.keySet());
        int[] re = new int[k];
        for (int i=0; i<k; i++){
            re[i] = priorityQueue.poll();
        }
        return re;
    }


    public static void main(String[] args) {
        int[] nums ={1,1,1,2,2,3};
        int k =2;
        Leetocde347 L = new Leetocde347();
        int[] re = L.topKFrequent(nums, k);
        System.out.println(Arrays.toString(re));
    }
}
