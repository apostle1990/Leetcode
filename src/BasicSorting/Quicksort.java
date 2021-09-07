package BasicSorting;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {
    private static final int base =7;
    private static final Random random = new Random();

    static public int[] sortArray(int[] nums) {
        int len = nums.length;
        quicksort(nums, 0, len-1);
        return nums;
    }


    static private void quicksort(int[] nums, int left, int right){
        if(right - left < base){
            insertionsort(nums,left,right);
            return;
        }
        int pIndex = partition(nums, left,right);
        quicksort(nums,left,pIndex-1);
        quicksort(nums, pIndex+1, right);
    }

    private static void insertionsort(int[] nums, int left, int right){
        for (int i = left +1; i<= right; i++){
            int temp = nums[i];
            int j = i;
            while (j> left && nums[j -1] > temp){
                nums[j] = nums[j -1];
                j--;
            }
            nums[j] = temp;
        }
    }

    private static int partition(int[] nums, int left, int right){
        int randomIndex = random.nextInt(right - left + 1) +left;
        swap(nums, left, randomIndex);

        int  pivot = nums[left];
        int lt = left;
        for(int i = left +1; i <= right; i++){
            if(nums[i] < pivot){
                lt++;
                swap(nums,i,lt);
            }
        }
        swap(nums,left,lt);
        return lt;
    }

    private static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        System.out.println(Arrays.toString(sortArray(nums)));
    }
}
