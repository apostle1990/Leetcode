package NoncomparativeSorting;

//feibijiaopaixu
public class Offer3 {
    public int findRepeatNumber(int[] nums) {
        //zhihuan
        int temp;
        for (int i=0;i < nums.length; i++){
           while (nums[i]!=i){
                if (nums[i] == nums[nums[i]]) return nums[i];
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
