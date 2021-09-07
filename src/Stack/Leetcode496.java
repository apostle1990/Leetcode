package Stack;

import java.util.*;

//下一个更大元素 I
public class Leetcode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //暴力法
        int l1= nums1.length,l2=nums2.length;
//        int[] re = new int[l1];
//        for (int i=0; i<l1; i++){
//            int curVal = nums1[i];
//            int j =0;
//            while (j <l2 && nums2[j] !=curVal){
//                j++;
//            }
//            j++;
//            while (j < l2 && nums2[j] <curVal){
//                j++;
//            }
//            if (j==l2){
//                re[i] = -1;
//                continue;
//            }
//            re[i] = nums2[j];
//        }
        //单调栈
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<l2; i++){
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]){
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }
        int[] re = new int[l1];
        for (int i=0; i<l1; i++){
            re[i] = map.getOrDefault(nums1[i], -1);
        }
        return re;
    }

    public static void main(String[] args) {
        Leetcode496 l = new Leetcode496();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] re = l.nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(re));
    }
}
