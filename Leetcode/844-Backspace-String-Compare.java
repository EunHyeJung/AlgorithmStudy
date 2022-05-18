/*
* @source https://leetcode.com/problems/backspace-string-compare/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.18
*/

class Solution {
    public final char BACKSPACE = '#';
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (int i = 0, n = s.length(); i < n; i++) {
            char curCh = s.charAt(i);
            if (curCh != BACKSPACE)
                sStack.push(curCh);
            else if (!sStack.isEmpty()){
                sStack.pop();    
            }
        }
        
        for (int i = 0, n = t.length(); i < n; i++) {
            char curCh = t.charAt(i);
            if (curCh != BACKSPACE)
                tStack.push(curCh);
            else if (!tStack.isEmpty()){
                tStack.pop();
            }
        }

        if (sStack.size() != tStack.size())
            return false;

        while (!sStack.isEmpty()) {
            if (sStack.pop() != tStack.pop())
                return false;
        }

        return true;
    }
}
