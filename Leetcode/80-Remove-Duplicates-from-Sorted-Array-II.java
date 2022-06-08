/*
* @source https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.06.08
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int totalNumCnt = 1, n = nums.length;
        if (n == 1)
            return totalNumCnt;

        int numCnt = 1, curNum = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == curNum) {
                numCnt += 1;
                if (numCnt > 2)
                    nums[i] = Integer.MIN_VALUE;
            } else {
                numCnt = 1;
                curNum = nums[i];
            }
            if (numCnt <= 2)
                totalNumCnt += 1;
        }
        for (int i = 0; i < n;) {
            int k = i;
            if (nums[i] == Integer.MIN_VALUE) {
                int j = i + 1;
                while (j < n && nums[j] == Integer.MIN_VALUE) {
                    j += 1;
                }
                while(k < j && j < n && nums[j] != Integer.MIN_VALUE) {
                    nums[k++] = nums[j++];
                    nums[j - 1] = Integer.MIN_VALUE;
                }
            }
            i = k > i ? k : i + 1;
        }
        return totalNumCnt;
    }
}
