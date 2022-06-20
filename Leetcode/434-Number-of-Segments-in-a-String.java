/*
* @source https://leetcode.com/problems/number-of-segments-in-a-string/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.06.20
*/
class Solution {
    public int countSegments(String s) {
        int res = 0;
        for(String splits : s.split(" ")) {
            if (splits.trim().length() > 0)
                res += 1;
        }
        return res;
    }
}
