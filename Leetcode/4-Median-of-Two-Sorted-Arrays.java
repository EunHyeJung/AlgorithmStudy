/*
* @source https://leetcode.com/problems/median-of-two-sorted-arrays/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.12
*/
class Solution {
    private boolean isOdd;
    private int targetPos;
    private int[] mergedArr;

    public double getMedian(int idx) {
        return this.isOdd ? mergedArr[idx] : (double) (mergedArr[idx] + mergedArr[idx - 1]) / 2;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalCnt = m + n;

        int curSor1 = 0; int curSor2 = 0;
        int idx = 0;

        this.mergedArr =  new int[m + n];
        this.isOdd = totalCnt % 2 == 1;
        this.targetPos = totalCnt / 2;

        while(curSor1 < m && curSor2 < n) {
            if(nums1[curSor1] < nums2[curSor2]) {
                mergedArr[idx] = nums1[curSor1];
                curSor1 += 1;
            } else {
                mergedArr[idx] = nums2[curSor2];
                curSor2 += 1;
            }
            if (idx == this.targetPos)
                return getMedian(idx);
            idx += 1;
        }

        while(curSor1 < m) {
            mergedArr[idx] = nums1[curSor1];
            if (idx == this.targetPos)
                return getMedian(idx);
            curSor1 += 1;
            idx += 1;
        }

        while(curSor2 < n) {
            mergedArr[idx] = nums2[curSor2];
            if (idx == totalCnt / 2)
                return getMedian(idx);
            curSor2 += 1;
            idx += 1;
        }


        return 0;
    }
}
