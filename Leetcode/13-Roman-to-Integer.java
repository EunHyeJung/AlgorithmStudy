/*
* @source https://leetcode.com/problems/roman-to-integer/submissions/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.23
*/
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int i = s.length() - 1;
        int res = 0;
        int cur = 0;
        while(i >= 0) {
            cur = (cur == 0) ? map.get(s.charAt(i)) : cur;
            if (i == 0) {
                res += cur;
                return res;
            }
            int prev = map.get(s.charAt(i - 1));
            if (prev < cur) {
                cur -= prev;
                res += cur;
                cur = 0;
                i -= 2;
            } else {
                res += cur;
                cur = prev;
                i -= 1;
            }
        }
        return res;
    }
}
