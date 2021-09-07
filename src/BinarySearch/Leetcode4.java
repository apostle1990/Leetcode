package BinarySearch;

public class Leetcode4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length,length2 = nums2.length;
        int lsum = length1 +length2;
        if (lsum % 2 ==1){
            int midindex = lsum/2;
            return getmind(nums1,nums2,midindex+1);
        }else {
            int midindex1 = lsum/2 -1 ,midindex2 = lsum/2;
            return (getmind(nums1,nums2,midindex1+1)+getmind(nums1,nums2,midindex2+1))/2.0;
        }
    }
    public static int getmind(int[] nums1, int[] nums2, int mid){
        int length1 = nums1.length,length2 = nums2.length;
        int index1 = 0, index2=0;
        while (true){
            if (index1 == length1){return nums2[index2+mid-1];}
            if (index2 == length2){return nums1[index1+mid-1];}
            if (mid == 1){return Math.min(nums1[index1],nums2[index2]);}//位置从一开始算
            int half = mid /2;
            int newindex1 = Math.min(index1+half,length1) -1;
            int newindex2 = Math.min(index2+half,length2) -1;
            int piovt1 = nums1[newindex1], piovt2 = nums2[newindex2];
            if (piovt1 <= piovt2){
                mid -= (newindex1 - index1 + 1);
                index1 = newindex1 +1;
            }else {
                mid -=(newindex2 - index2 + 1);
                index2 = newindex2+1;
            }
        }
    }
}
