/*
* @source https://leetcode.com/problems/same-tree/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.17
*/
public int[] productExceptSelf(int[] nums) {
    int prodcut = 1;
    int n = nums.length;
    int zeroCnt = 0;
    for (int num : nums) {
        if (num == 0) {
            zeroCnt += 1;
            continue;
        }
        prodcut *= num;
    }

    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
        if (nums[i] == 0)
            res[i] = zeroCnt == n ? 0 : prodcut;
        else if (zeroCnt > 0 && nums[i] != 0)
            res[i] = 0;
        else {
            res[i] = prodcut / nums[i];
        }
    }
    return res;
}
