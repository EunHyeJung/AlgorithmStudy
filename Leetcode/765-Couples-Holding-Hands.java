/*
* @source https://leetcode.com/problems/same-tree/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.06
*/
class Solution {
    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> seatMap = new HashMap<>();
        for (int i = 0, n = row.length; i < n; i++)
            seatMap.put(row[i], i);
        int swapCnt = 0;


        for (int i = 0, n = row.length ; i < n; i += 2) {
            int couple = row[i] % 2 == 0 ? row[i] + 1 : row[i] - 1;
            int seatPos = seatMap.get(couple);
            if (Math.abs(seatPos - seatMap.get(row[i]))  > 1) {
                swapCnt += 1;
                int tmp = row[i + 1];
                row[i + 1] = couple;
                row[seatPos] = tmp;
                seatMap.put(tmp, seatPos);
            }
        }
        return swapCnt;
    }
}
