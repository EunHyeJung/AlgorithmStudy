import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/11725
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.09.30
*/
public class Main {
	public static void main(String[] args) {
		try {
			Tree tree = new Tree();
			tree.printTreeParent();
		} catch (IOException e) {

		}
	}
}

class Tree {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	private static final int ROOT = 1;
	private int n;
	private int[] parent;
	private List<Integer>[] adj;

	public Tree() throws IOException {
		this.n = Integer.parseInt(br.readLine());
		this.adj = (List<Integer>[]) new List[n + 1];

		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		this.parent = new int[n + 1];
		this.buildTree();
	}

	public void buildTree() throws IOException {
		int counter = n;
		while (counter-- > 1) {
			st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			adj[node1].add(node2);
			adj[node2].add(node1);
		}
	}

	public void findParent(int node) {
		for (int adjNode : adj[node]) {
			if (parent[adjNode] == 0) {
				parent[adjNode] = node;
				findParent(adjNode);
			}
		}
	}

	public void printTreeParent() {
		findParent(ROOT);

		StringBuffer sb = new StringBuffer();
		for (int i = 2; i <= n; i++) {
			sb.append(parent[i] + "\n");
		}
		System.out.println(sb);
	}

}
