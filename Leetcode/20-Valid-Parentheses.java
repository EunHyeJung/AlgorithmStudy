/*
* @source https://leetcode.com/problems/valid-parentheses/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.08
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0, n = s.length(); i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;
                if (!isPair(stack.pop(), ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isPair(char open, char close) {
        if (open == '(' && close == ')')
            return  true;
        else if (open == '[' && close == ']')
            return true;
        else if (open == '{' && close == '}')
            return true;
        return false;
    }
}
