/*
* @source https://leetcode.com/problems/3sum/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.05
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <n ;i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1, r = n - 1;
            int  target = -nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l + 1])
                        l++;
                    while(l < r && nums[r] == nums[r - 1])
                        r--;
                    l++; r--;
                } else if (nums[l] + nums[r] < target)
                    l++;
                else
                    r--;
            }
        }
        return res;
    }
}
