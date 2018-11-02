import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @source https://www.acmicpc.net/problem/2252
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2018.11.02
 */
public class Main {


    public static void main(String[] args) {
        try {
            StudentController studentController = new StudentController();
            studentController.standLine();
        } catch (IOException e) {

        }
    }

}

class StudentController {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int n;
    private List<Integer>[] adj;
    private int[] ind;

    public StudentController() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        this.n = Integer.parseInt(st.nextToken());
        this.adj = (List<Integer>[]) new List[n + 1];
        this.ind = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(st.nextToken());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            ind[to] += 1;
        }
    }

    public void standLine() {
        StringBuilder res = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (ind[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.append(cur + " ");
            for (int s : adj[cur]) {
                ind[s] -= 1;
                if (ind[s] == 0) {
                    queue.add(s);
                }
            }
        }
        System.out.println(res);
    }

}
