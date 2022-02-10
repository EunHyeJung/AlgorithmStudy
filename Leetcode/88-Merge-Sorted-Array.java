/*
* @source https://leetcode.com/problems/merge-sorted-array/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.10
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for(int i = 0; i  < n; i++)
                nums1[i] = nums2[i];
        } else if (n > 0) {
            int mi = m - 1;
            int ni = n - 1;
            int mni = m + n - 1;
            while (mi >= 0 && ni >= 0) {
                if (nums1[mi] >= nums2[ni]) {
                    nums1[mni--] = nums1[mi];
                    nums1[mi--] = 0;
                } else {
                    nums1[mni--] = nums2[ni--];
                }
            }

            if (mi >= 0) {
                while(mi >= 0) {
                    nums1[mni--] = nums1[mi--];
                }
            } else if(ni >= 0) {
                while(ni >= 0) {
                    nums1[mni--] = nums2[ni--];
                }
            }
        }
    }
}
