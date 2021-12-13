/*
* @source https://leetcode.com/problems/two-sum/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.13
*/
var twoSum = function(nums, target) {
    let n = nums.length;
    let numMap = {};
    for(let i = 0; i < n; i++) {
        if (numMap[target - nums[i]] != undefined) {
          return([i, numMap[target - nums[i]]]);
        }
        numMap[nums[i]] = i;
    }
};
