/*
* @source https://leetcode.com/problems/4sum/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.25
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for(int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])    continue;
                int subTarget = target - nums[i] - nums[j];
                int k = j + 1, l = n - 1;
                while(k < l) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        k += 1;
                        continue;
                    }
                    if (l < n - 1 && nums[l] == nums[l + 1]) {
                        l -= 1;
                        continue;
                    }
                    if (nums[k] + nums[l] == subTarget) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k += 1;
                        l -= 1;
                    } else if (nums[k] + nums[l] < subTarget) {
                        k += 1;
                    } else {
                        l -= 1;
                    }
                }
            }
        }

        return res;
    }
}
