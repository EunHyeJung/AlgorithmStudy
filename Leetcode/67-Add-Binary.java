/*
* @source https://leetcode.com/problems/add-binary/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.24
*/
class Solution {
public String addBinary(String a, String b) {
        int aN = a.length(), bN = b.length();
        int aIdx = aN - 1, bIdx = bN - 1;
        boolean flag = false;
        StringBuilder sb = new StringBuilder();

        while(aIdx >= 0 && bIdx >= 0) {
            int sum = a.charAt(aIdx) - '0' + b.charAt(bIdx) - '0';
            if (sum == 0) {
                if (flag) {
                    sb.append("1");
                    flag = false;
                } else
                    sb.append("0");
            } else if (sum == 1) {
                if (flag) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            } else {    // sum == 2
                if (flag) {
                    sb.append("1");
                    flag = true;
                } else {
                    sb.append("0");
                    flag = true;
                }
            }
            aIdx -= 1;
            bIdx -= 1;
        }

        while (aIdx >= 0) {
            int cur = a.charAt(aIdx);
            if (cur == '0') {
                if (flag) {
                    sb.append("1");
                    flag = false;
                } else
                    sb.append("0");
            } else {    // '1'
                if (flag)
                    sb.append("0");
                else
                    sb.append("1");
            }
            aIdx -= 1;
        }

        while (bIdx >= 0) {
            int cur = b.charAt(bIdx);
            if (cur == '0') {
                if (flag) {
                    sb.append("1");
                    flag = false;
                } else
                    sb.append("0");
            } else {    // '1'
                if (flag)
                    sb.append("0");
                else
                    sb.append("1");
            }
            bIdx -= 1;
        }
        if (flag)
            sb.append("1");
        return sb.reverse().toString();
    }
}
