import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * @source https://www.acmicpc.net/problem/11724
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2018.10.18
 */
public class Main {
    public static void main(String[] args) {
        try {
            Graph graph = new Graph();
            System.out.println(graph.getConnectedComponentCnt());
        } catch (IOException e) {

        }
    }
}

class Graph {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int n, m;
    private List<Integer>[] adj;
    private boolean[] chk;

    public Graph() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        this.n = Integer.parseInt(st.nextToken());
        this.m = Integer.parseInt(st.nextToken());
        this.adj = (List<Integer>[]) new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        this.setNodeInfo();
        this.chk = new boolean[n + 1];
    }

    public void setNodeInfo() throws IOException {
        StringTokenizer st = null;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
    }

    public int getConnectedComponentCnt() {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!chk[i]) {
                cnt += 1;
                dfs(i);
            }
        }
        return cnt;
    }

    public void dfs(int cur) {
        for (int adjNode : adj[cur]) {
            if (!chk[adjNode]) {
                chk[adjNode] = true;
                dfs(adjNode);
            }
        }
    }
}
