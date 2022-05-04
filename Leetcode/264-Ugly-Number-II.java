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
            if (curNum <= MAX_VALUE_1 && !uglyNumQueue.contains(curNum * 2))
                uglyNumQueue.add(curNum * 2);
            if (curNum <= MAX_VALUE_2 && !uglyNumQueue.contains(curNum * 3))
                uglyNumQueue.add(curNum * 3);
            if (curNum <= MAX_VALUE_3 && !uglyNumQueue.contains(curNum * 5))
                uglyNumQueue.add(curNum * 5);
        }

        return 0;
    }
}
