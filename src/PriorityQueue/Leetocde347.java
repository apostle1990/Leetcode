package PriorityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Leetocde347 {
    //    private static class node{
//        private int key;
//        private int value;
//        public node() {}
//        public node(int key, int value){
//            this.key = key;
//            this.value =value;
//        }
//    }
//    public int[] topKFrequent(int[] nums, int k) {
//        PriorityQueue<node> priorityQueue = new PriorityQueue<>((x, y) -> y.value - x.value);
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i : nums){
//            if (hashMap.containsKey(i)){
//                hashMap.put(i, hashMap.get(i)+1);
//            }else {
//                hashMap.put(i, 1);
//            }
//        }
//        for (int i : hashMap.keySet()){
//            node node = new node(i, hashMap.get(i));
//            priorityQueue.add(node);
//        }
//        int[] re = new int[k];
//        int i =0;
//        while(i <k){
//            re[i] = priorityQueue.poll().key;
//            i++;
//        }
//        return re;
//    }
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
