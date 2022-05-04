/*
* @source https://leetcode.com/problems/ugly-number-ii/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.04
*/
class Solution {
    private static final int MAX_VALUE_1 = Integer.MAX_VALUE / 2;
    private static final int MAX_VALUE_2 = Integer.MAX_VALUE / 3;
    private static final int MAX_VALUE_3 = Integer.MAX_VALUE / 5;

    public int nthUglyNumber(int n) {
        Queue<Integer> uglyNumQueue = new PriorityQueue<>();
        uglyNumQueue.add(1);
        int count = 0;

        while(!uglyNumQueue.isEmpty()) {
            int curNum = uglyNumQueue.poll();
            count += 1;
            if (count == n)
                return curNum;

            int nextNum = curNum * 2;
            if (curNum <= MAX_VALUE_1) {
                uglyNumQueue.add(nextNum);
            }
            nextNum = curNum * 3;
            if (curNum <= MAX_VALUE_2 && nextNum % 2 != 0) {
                uglyNumQueue.add(nextNum);
            }
            nextNum = curNum * 5;
            if (curNum <= MAX_VALUE_3 && nextNum % 2 != 0 && nextNum % 3 != 0) {
                uglyNumQueue.add(nextNum);
            }
        }

        return 0;
    }
}
