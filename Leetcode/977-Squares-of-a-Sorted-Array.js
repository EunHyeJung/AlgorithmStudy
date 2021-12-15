/*
* @source https://leetcode.com/problems/squares-of-a-sorted-array/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.15
*/
var sortedSquares = function(nums) {
    return nums.map((num) => num * num).sort((a, b) => { return a - b});
};
