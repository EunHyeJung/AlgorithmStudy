/*
* @source https://leetcode.com/problems/same-tree/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.04
*/
class Solution {
    private List<List<Integer>> res;
    private int n;

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        res = new ArrayList<>();

        res.add(new ArrayList<>());

        for (int k = 1; k <= n; k++) {
            getSubSets(nums, k, 0, new ArrayList<>());
        }

        return res;
    }

    public void getSubSets(int[] nums, int k, int start, List<Integer> curList) {
        if (curList.size() == k) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = start; i < n; i++) {
            curList.add(nums[i]);
            getSubSets(nums, k, i + 1, curList);
            curList.remove(curList.size() - 1);
        }
    }
}
