import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 *  @date : 2020-03-26
 *  @source : https://www.acmicpc.net/problem/5014
 *  @email : ehye826@gamil.com
 * */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String[] inputs = br.readLine().split(" ");
        new Main().findOffice(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]), Integer.parseInt(inputs[4]));
    }

    public void findOffice(int f, int s, int g, int up, int down) {
        boolean[] chk = new boolean[f + 1];
        Queue<State> queue = new LinkedList<State>();
        queue.add(new State(s, 0));
        chk[s] = true;

        while (!queue.isEmpty()) {
            State curState = queue.poll();
            int curFloor = curState.getFloor();
            if (curFloor == g) {
                System.out.println(curState.getStep());
                return;
            }
            if (curFloor + up <= f && !chk[curFloor + up]) {
                chk[curFloor + up] = true;
                queue.add(new State(curFloor + up, curState.getStep() + 1));
            }
            if (curFloor - down > 0 && !chk[curFloor - down]) {
                chk[curFloor - down] = true;
                queue.add(new State(curFloor - down, curState.getStep() + 1));
            }
        }
        System.out.println("use the stairs");
        return;
    }

    class State {
        private int floor;
        private int step;

        public State(int floor, int step) {
            this.floor = floor;
            this.step = step;
        }

        public int getStep() {
            return this.step;
        }

        public int getFloor() {
            return this.floor;
        }
    }
}
