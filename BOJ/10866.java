import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/10866
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.08
*/
public class Solution {
    public static void main(String[] args) {
        try {
            DequeOperator dequeOperator = new DequeOperator();
            dequeOperator.processCmd();
        } catch (IOException e) {

        }
    }
}

class DequeOperator {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public StringTokenizer st;
    private Deque deque;
    private int n;

    public DequeOperator() throws IOException {
        deque = new ArrayDeque<>();
        this.n = Integer.parseInt(br.readLine());
    }

    public void processCmd() throws IOException {
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            switch (cmd) {
                case "push_front": {
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "push_back": {
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "front": {
                    int ele = -1;
                    ele = !deque.isEmpty() ? (int) deque.getFirst() : -1;
                    System.out.println(ele);
                    break;
                }
                case "back": {
                    int ele = -1;
                    ele = !deque.isEmpty() ? (int) deque.getLast() : -1;
                    System.out.println(ele);
                    break;
                }
                case "pop_front": {
                    int ele = -1;
                    ele = !deque.isEmpty() ? (int) deque.pollFirst(): -1;
                    System.out.println(ele);
                    break;
                }
                case "pop_back": {
                    int ele = -1;
                    ele = !deque.isEmpty() ? (int) deque.pollLast(): -1;
                    System.out.println(ele);
                    break;
                }
                case "size": {
                    System.out.println(deque.size());
                    break;
                }
                case "empty": {
                    if (deque.isEmpty()) {
                        System.out.println(1);
                        break;
                    }
                    System.out.println(0);
                    break;
                }
            }
        }
    }

}
