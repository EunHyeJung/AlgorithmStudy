import java.io.*;
import java.util.*;

/*
* @source https://www.acmicpc.net/problem/11437
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.12
*/

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            LCAFinder lcaFinder = new LCAFinder();
            lcaFinder.printLCA();
        } catch (IOException e) {

        }
    }
}

class LCAFinder {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private int n;
    private List<Integer>[] adjNodes;
    private int[] parent;
    private int[] depth;

    public LCAFinder() throws IOException {
        this.n = Integer.parseInt(br.readLine());
        this.parent = new int[n + 1];
        this.depth = new int[n + 1];
        this.adjNodes = (List<Integer>[]) new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adjNodes[i] = new ArrayList<>();
        }
        this.updateNodeInfo();
    }

    public void updateNodeInfo() throws IOException {
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adjNodes[node1].add(node2);
            adjNodes[node2].add(node1);
        }
        bfs();
    }

    // 각 노드의 dpeth와 parent를 찾아서 업데이트.
    public void bfs() {
        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.add(1);
        depth[1] = 1;
        while (!nodeQueue.isEmpty()) {
            int node = nodeQueue.poll();
            for (int adjNode : adjNodes[node]) {
                if (depth[adjNode] == 0) {
                    depth[adjNode] = depth[node] + 1;
                    parent[adjNode] = node;
                    nodeQueue.add(adjNode);
                }
            }
        }
    }

    public void printLCA() throws IOException {
        StringBuffer res = new StringBuffer();
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int tmp = node1;
            node1 = (depth[node1] > depth[node2]) ? node1 : node2; // 무조건 node1의 깊이가 더큼
            node2 = (depth[tmp] > depth[node2]) ? node2 : tmp;

            // 깊이를 맞춰준다.
            while (depth[node1] != depth[node2]) {
                node1 = parent[node1];
            }
            
            // lca를 찾는다.
            while (node1 != node2) {
                node1 = parent[node1];
                node2 = parent[node2];
            }
            res.append(node1 + "\n");
        }
        bw.write(res.toString());
        bw.flush();
        bw.close();
    }
}
