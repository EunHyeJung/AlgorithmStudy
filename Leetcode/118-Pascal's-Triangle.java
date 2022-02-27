/*
* @source https://leetcode.com/problems/pascals-triangle/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.27
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        if (numRows == 1)
            return res;
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevList = res.get(i - 1);
            List<Integer> curList = new ArrayList<>();
            curList.add(1);
            int curNum = prevList.get(0), nextNum = 0;
            for (int j = 0, n = prevList.size(); j < n - 1; j++) {
                nextNum = prevList.get(j + 1);
                curList.add(curNum + nextNum);
                curNum = nextNum;
            }
            curList.add(1);
            res.add(curList);
        }
        return res;
    }
}
