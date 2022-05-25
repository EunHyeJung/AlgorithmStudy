/*
* @source https://leetcode.com/problems/longest-valid-parentheses/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.25
*/

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int len = 0;
        if (n == 0)
            return len;

        Stack<Integer> stack = new Stack<>();

        int[] dp = new int[n];
        boolean[] isValid = new boolean[n];
        if (s.charAt(0) == '(') {
            stack.push(0);
        }

        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                 dp[i] = 0;
                 stack.push(i);
            } else {    // ch == ')'
                if (!stack.isEmpty()) {
                    int idx = stack.pop();
                    dp[i] = i - idx + 1;
                    isValid[i] = true;
                    if (idx > 0 && isValid[idx - 1])
                        dp[i] += dp[idx - 1];
                } else {
                    dp[i] = 0;
                }

            }
            len = Math.max(len, dp[i]);

        }
        return len;
    }
}
