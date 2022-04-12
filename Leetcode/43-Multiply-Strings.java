/*
* @source https://leetcode.com/problems/multiply-strings/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.12
*/
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int prev = 0;
        List<String> list = new ArrayList<>();
        int maxLen = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            sb.append("0".repeat(num2.length() - 1 - i));
            for (int j = num1.length() - 1; j >= 0; j--) {
                int multiplyVal = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + prev;
                prev = multiplyVal /10;
                multiplyVal %= 10;
                sb.append(multiplyVal);
            }
            if (prev > 0) {
                sb.append(prev);
                prev = 0;
            }
            maxLen = Math.max(sb.length(), maxLen);
            list.add(sb.reverse().toString());
        }
        StringBuilder res = new StringBuilder();
        prev = 0;
        for (int i = 0; i < maxLen; i++) {
            int sum = 0;
            for(String str : list) {
                int strLen = str.length();
                if (strLen > i) {
                    sum += (str.charAt(strLen - 1 - i) - '0');
                }
            }
            sum += prev;
            prev = sum / 10;
            sum %= 10;
            res.append(sum);
        }
        if (prev > 0)
            res.append(prev);
        return res.reverse().toString();
    }
}
