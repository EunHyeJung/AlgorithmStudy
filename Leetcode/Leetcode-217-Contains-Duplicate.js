/*
* @source https://leetcode.com/problems/contains-duplicate/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.06
*/
var containsDuplicate = function(nums) {
    return new Set(nums).size != nums.length;
};
