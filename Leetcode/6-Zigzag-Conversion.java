/*
* @source https://leetcode.com/problems/zigzag-conversion/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.01.11
*/
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)   return s;
        Map<Integer, StringBuilder> map = new HashMap<>();
        int curRow = 0, flag = 1;

        for(int i = 0, n = s.length(); i < n; i++) {
            if (!map.containsKey(curRow))
                map.put(curRow, new StringBuilder());

            StringBuilder sb = map.get(curRow);
            sb.append(s.charAt(i));
            map.put(curRow, sb);
            
            curRow += flag;
            if (curRow == numRows || curRow < 0) {
                flag *= -1;
                curRow += flag * 2;
            }
        }

        StringBuilder res = new StringBuilder();
        for(int key : map.keySet()) {
            res.append(map.get(key));
        }

        return res.toString();
    }
}
