/*
* @source https://leetcode.com/problems/insert-interval/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.21
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<Interval> stack = new Stack<>();
        int n = intervals.length;
        if (intervals.length == 0)
            return new int[][] { newInterval };
        if (intervals[0][0] > newInterval[0])
            stack.push(new Interval(newInterval[0], newInterval[1]));

        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && stack.peek().getEnd() < newInterval[0] && intervals[i][0] > newInterval[1]) {
                stack.push(new Interval(newInterval[0], newInterval[1]));
            }
            if (intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]) {
                stack.push(new Interval(intervals[i][0], intervals[i][1]));
            } else {
                int st = Math.min(newInterval[0], intervals[i][0]);
                int end = Math.max(newInterval[1], intervals[i][1]);

                if (!stack.isEmpty()) {
                    Interval prevInterVal = stack.peek();
                    if (prevInterVal.getSt() <= st && prevInterVal.getEnd() >= st) {
                        st = Math.min(st, prevInterVal.getSt());
                        end = Math.max(end, prevInterVal.getEnd());
                        stack.pop();
                    }
                }
                stack.push(new Interval(st, end));
            }
        }
        if (newInterval[0] > intervals[n - 1][1]) {
            stack.push(new Interval(newInterval[0], newInterval[1]));
        }

        int[][] res = new int[stack.size()][2];
        int ri = stack.size() - 1;
        while (!stack.isEmpty()) {
            Interval interval = stack.pop();
            res[ri][0] = interval.getSt();
            res[ri][1] = interval.getEnd();
            ri -= 1;
        }
        return res;
    }
}

class Interval {
    private int st;
    private int end;

    public Interval(int st, int end) {
        this.st = st;
        this.end = end;
    }

    public int getSt() {
        return st;
    }

    public int getEnd() {
        return end;
    }
}
