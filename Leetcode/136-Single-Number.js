/*
* @source https://leetcode.com/problems/single-number/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.27
*/
var singleNumber = function(nums) {
    let n = nums.length;
    if (n == 1)
        return nums[0];
    nums.sort();
    for(let i = 0; i < n;) {
        if (i + 1 < n && nums[i] != nums[i + 1]) {
            return nums[i];
        }
        i += 2;
    }
    return nums[n-1];
};
