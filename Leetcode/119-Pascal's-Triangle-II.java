/*
* @source https://leetcode.com/problems/pascals-triangle-ii/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.27
*/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascalTriangleList = new ArrayList<>();
        pascalTriangleList.add(new ArrayList<>(Arrays.asList(1)));
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curList = new ArrayList<>();
            List<Integer> prevList = pascalTriangleList.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    curList.add(1);
                else {
                    curList.add(prevList.get(j - 1) + prevList.get(j));
                }
            }
            pascalTriangleList.add(curList);
        }
        return pascalTriangleList.get(rowIndex);
    }
}
