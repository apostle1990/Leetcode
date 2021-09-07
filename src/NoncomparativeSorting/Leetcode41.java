package NoncomparativeSorting;

public class Leetcode41 {
    static public int firstMissingPositive(int[] nums) {
        //哈希
        int len = nums.length;
        for(int i=0; i<len; i++){
            if (nums[i] <=0){
                nums[i] =len +1;
            }
        }
        for (int i =0; i<len; ++i){
            int num = Math.abs(nums[i]);
            if (num <= len){
                nums[num -1] = -Math.abs(nums[num -1]);
            }
        }
        for (int i=0; i<len; i++){
            if (nums[i] >0) return i+1;
        }
        return len + 1;
    }
    static public int MissingPositive(int[] nums) {
        //zhihuan
        int len = nums.length;
        for (int i =0; i< len; ++i){
            while (nums[i] >0 && nums[i] <= len && nums[nums[i] -1] != nums[i]){
                int temp = nums[nums[i] -1];
                nums[nums[i] -1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i=0; i< len; ++i){
            if(nums[i] != i+1){
                return i +1;
            }
        }
        return len +1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
    }
}
