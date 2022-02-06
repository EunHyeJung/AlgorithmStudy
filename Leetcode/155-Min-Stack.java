/*
* @source https://leetcode.com/problems/min-stack/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.06
*/
class MinStack {
    private List<Integer> stack;
    private PriorityQueue<Integer> sortedNums;
    private int size = 0;
    public MinStack() {
        stack = new ArrayList<>();
        sortedNums = new PriorityQueue<>();
    }
    
    public void push(int val) {
        stack.add(val);
        sortedNums.add(val);
        size += 1;
    }
    
    public void pop() {
        int removedNum = stack.remove(size - 1);
        sortedNums.remove(removedNum);
        size -= 1;
    }
    
    public int top() {
        return stack.get(size - 1);
    }
    
    public int getMin() {
        return sortedNums.peek();
    }
}

