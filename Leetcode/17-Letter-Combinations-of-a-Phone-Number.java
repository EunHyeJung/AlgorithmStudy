/*
 * @source https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2022.05.10
 */
 class Solution {
    private Map<Integer,String> numMap;
    private List<String> result;
    public Solution() {
        numMap = new HashMap<>();
        result = new ArrayList<>();

        numMap.put(2, "abc");
        numMap.put(3, "def");
        numMap.put(4, "ghi");
        numMap.put(5, "jkl");
        numMap.put(6, "mno");
        numMap.put(7, "pqrs");
        numMap.put(8, "tuv");
        numMap.put(9, "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n > 0)
          getLetters(digits, 0, new StringBuilder(), n);
        return result;
    }

    public void getLetters(String digits, int curIdx, StringBuilder sb, int n) {
       if (curIdx > n - 1) {
           result.add(sb.toString());
           return;
       }
        String str = numMap.get(digits.charAt(curIdx) - '0');
       for (char ch : str.toCharArray()) {
           sb.append(ch);
           getLetters(digits,curIdx + 1, sb, n);
           sb.deleteCharAt(sb.length() - 1);
       }
    }
}
