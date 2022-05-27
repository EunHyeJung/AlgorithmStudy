/*
* @source https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.27
*/
class Solution {
    public int numberOfSteps(int num) {
        int step = 0;
        
        while (num > 0) {
            if (num % 2 == 0)
                num /= 2;
            else 
                num -= 1;
            step += 1;
        }
        return step;
    }
}
