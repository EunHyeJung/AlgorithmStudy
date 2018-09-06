import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		History history = new History();
		history.init();
		history.getRes();
	}

}

class History {
	private int n;
	private int[][] nodes;

	public void init() throws IOException {

		String[] inputs = IOUtil.readInput().split(" ");
		this.n = Integer.parseInt(inputs[0]);
		int k = Integer.parseInt(inputs[1]);

		this.nodes = new int[n + 1][n + 1];

		for (int event = 0; event < k; event++) {
			inputs = IOUtil.readInput().split(" ");
			int prevEvent = Integer.parseInt(inputs[0]);
			int nextEvent = Integer.parseInt(inputs[1]);
			nodes[prevEvent][nextEvent] = -1;
			nodes[nextEvent][prevEvent] = 1;
		}
	}

	public void print() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(nodes[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void chkRelation() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i != j && nodes[i][j] == 0) {
						nodes[i][j] = ((nodes[i][k] == nodes[k][j]) ? nodes[i][k] : 0);
						nodes[j][i] = (-1) * nodes[i][j];
					}
				}
			}
		}

	}

	public void getRes() throws IOException {
		chkRelation();
		int s = Integer.parseInt(IOUtil.readInput());
		for (int question = 0; question < s; question++) {
			String[] inputs = IOUtil.readInput().split(" ");
			IOUtil.printOutput(nodes[Integer.parseInt(inputs[0])][Integer.parseInt(inputs[1])]);
		}
	}

}

class IOUtil {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static String readInput() throws IOException {
		return br.readLine();
	}

	public static void printOutput(int input) throws IOException {
		bw.write(input + "\n");
		bw.flush();
	}

}
