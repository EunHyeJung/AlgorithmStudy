/*
* @source https://leetcode.com/problems/majority-element/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.28
*/
var majorityElement = function(nums) {
    let n = nums.length, majorityCnt = parseInt(n / 2);
    let curNum = 0, curNumCnt = 0;
    nums.sort((a, b) => {return a - b});    
    for(let i = 0; i <n; i++) {
        if (curNum != nums[i]) {
            curNum = nums[i];
            curNumCnt = 0;
        }
        curNumCnt += 1;
        if (curNumCnt > majorityCnt)
            return curNum;
    }
    return curNum;
};
