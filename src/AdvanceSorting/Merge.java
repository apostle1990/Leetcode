package AdvanceSorting;

import java.util.Arrays;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m-1;
        if (m!=0){
            for (int i = 0;i < nums2.length;i++){
                int back1 = len;
                len++;
                if (n!=0){
                    for (int j= back1;j>=0;j--){
                        if (nums1[j]>nums2[i]){
                            nums1[j+1] = nums1[j];
                        }else {
                            nums1[j+1]=nums2[i];
                            break;
                        }
                        if (j == 0){
                            nums1[0] = nums2[i];
                        }
                    }
                }

            }
        }else {
            int i=0;
            for (int num:nums2){
                nums1[i]=num;
                i++;
            }
        }
        System.out.print(Arrays.toString(nums1));
    }

    public void tmerge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        Merge leetcode88 = new Merge();
        int[] nums1 = {0};
        int m = 0;
        int[] nums2= {1};
        int n = 1;
        leetcode88.merge(nums1,m,nums2,n);
    }
}