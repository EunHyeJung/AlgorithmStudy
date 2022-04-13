/*
* @source https://leetcode.com/problems/decode-string/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.13
*/
class Solution {
public String decodeString(String s) {
        Stack<String> chStack = new Stack<>();
        for (int i = 0, n = s.length(); i < n;) {
            char curCh = s.charAt(i);
            if (curCh != ']') {
                if (Character.isDigit(curCh)) {
                    int j = i;
                    while(j < n && Character.isDigit(s.charAt(j))) {
                        j += 1;
                    }
                    chStack.push(s.substring(i, j));
                    i = j;

                } else {
                    chStack.push(Character.toString(curCh));
                    i += 1;
                }
            } else {
                StringBuilder sb = new StringBuilder();
                while (!chStack.isEmpty() && !chStack.peek().equals("[")) {
                    sb.append(chStack.pop());
                }
                chStack.pop();
                chStack.push(sb.toString().repeat(Integer.parseInt(chStack.pop())));
                i += 1;
            }
        }
        StringBuilder res = new StringBuilder();
        while (!chStack.isEmpty()) {
            res.append(chStack.pop());
        }
        return res.reverse().toString();
    }
}
