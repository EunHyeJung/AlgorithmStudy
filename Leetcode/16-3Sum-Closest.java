/*
* @source https://leetcode.com/problems/3sum-closest/submissions/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.04
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if (n <= 3) {
            return nums[0] + nums[1] + nums[2];
        }
        
        Arrays.sort(nums);

        int i = 0, j = 0, k = 0;
        int minDiff = 9999, prevDiff = 9999, prevSum = 0;
        int res = 0;

        while (i < n) {
            j = i + 1;
            while (j < n) {
                k = j + 1;
                prevDiff = 9999;
                while (k < n) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) return sum;
                    if (Math.abs(target - sum) <= prevDiff) {
                        prevDiff = Math.abs(target - sum);
                        prevSum = sum;
                    } else
                        break;
                    k += 1;
                }
                if (prevDiff < minDiff) {
                    res = prevSum;
                    minDiff = prevDiff;
                }
                j += 1;

            }
            i += 1;
        }
        return res;
    }
}
