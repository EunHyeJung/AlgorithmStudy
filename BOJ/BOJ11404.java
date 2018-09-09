import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BusController busController = new BusController();
		busController.printCost();
	}
}

class BusController {
	private int n;
	private int m;
	private int[][] busCost;

	public BusController() throws IOException {
		this.n = Integer.parseInt(IOUtils.readInput());
		this.m = Integer.parseInt(IOUtils.readInput());

		this.busCost = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(busCost[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < m; i++) {
			String[] inputs = IOUtils.readInput().split(" ");
			int src = Integer.parseInt(inputs[0]);
			int dest = Integer.parseInt(inputs[1]);
			int cost = Integer.parseInt(inputs[2]);
			busCost[src][dest] = Math.min(cost, busCost[src][dest]);
		}
	}

	public void getCost() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i != j && busCost[i][k] != Integer.MAX_VALUE && busCost[k][j] != Integer.MAX_VALUE) {
						busCost[i][j] = Math.min(busCost[i][j], busCost[i][k] + busCost[k][j]);
					}

				}
			}
		}
	}

	public void printCost() throws IOException {
		getCost();

		StringBuilder res = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (busCost[i][j] == Integer.MAX_VALUE) {
					res.append(0 + " ");
				} else {
					res.append(busCost[i][j] + " ");
				}
			}
			res.append("\n");
		}
		IOUtils.writeOutput(res.toString());
	}

}

class IOUtils {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static String readInput() throws IOException {
		return br.readLine();
	}

	public static void writeOutput(int input) throws IOException {
		bw.write(input + "\n");
		bw.flush();
	}
	public static void writeOutput(String input) throws IOException {
		bw.write(input);
		bw.flush();
	}
	
}
