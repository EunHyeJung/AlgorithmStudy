/*
* @source https://leetcode.com/problems/find-common-characters/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.14
*/
class Solution {
    List<List<Integer>> result;
    boolean[] chk;

    public Solution() {
        this.result = new ArrayList<>();
    }
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n + 1];
        chk = new boolean[n];

        for (int i = 0; i < n; i++)
            nums[i] = i + 1;
        getCombination(nums, 0, k, n, new ArrayList<>());
        return this.result;
    }

    public void getCombination(int[] nums, int st, int k, int n, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = st; i < n; i++) {
            if (chk[i])
                continue;
            list.add(nums[i]);
            chk[i] = true;
            getCombination(nums, i + 1, k, n, list);
            list.remove(Integer.valueOf(nums[i]));
            chk[i] = false;
        }

    }
}
