/*
* @source https://leetcode.com/problems/find-common-characters/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.06.22
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int i = 0;

        Queue<NumInfo> pq = new PriorityQueue<>((o1, o2) -> o2.getNum() == o1.getNum() ? o1.getIdx() - o2.getIdx() :o2.getNum() - o1.getNum());

        while (i < n && i < k) {
            pq.add(new NumInfo(nums[i], i));
            i += 1;
        }
        res[0] = pq.peek().getNum();


        while(i < n) {
            NumInfo curNumInfo = pq.peek();
            pq.add(new NumInfo(nums[i], i));
            if (nums[i] > res[i - k]) {
                res[i - k + 1] = nums[i];
            } else if (curNumInfo.getIdx() <= i - k) {
                while(!pq.isEmpty() && pq.peek().getIdx() <= i -k)
                    pq.poll();
                res[i - k + 1] = pq.peek().getNum();
            } else {
                res[i - k + 1] = curNumInfo.getNum();
            }
            i += 1;
        }
        return res;
    }
}


class NumInfo {
    private int num;
    private int idx;

    public NumInfo(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    public int getNum() {
        return num;
    }

    public int getIdx() {
        return idx;
    }
}
