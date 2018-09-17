import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* BOJ 15686 
* @source
*/
public class Main {
	public static void main(String[] args) {
		try {
			StoreController storeController = new StoreController();
			int minDist = storeController.getMinChickentDist();
			IOUtils.writeOutput(minDist);
		} catch (IOException e) {

		}
	}
}

class StoreController {

	private static final int HOUSE = 1;
	private static final int STORE = 2;
	private int n, m;
	private List<Pos> storeList;
	private List<Pos> houseList;
	private int minChickenDist;

	public StoreController() throws IOException {
		storeList = new ArrayList<>();
		houseList = new ArrayList<>();
		minChickenDist = Integer.MAX_VALUE;
		this.init();
	}

	public void init() throws IOException {
		String[] inputs = IOUtils.readInput().split(" ");
		this.n = Integer.parseInt(inputs[0]);
		this.m = Integer.parseInt(inputs[1]);
		for (int y = 1; y <= n; y++) {
			inputs = IOUtils.readInput().split(" ");
			for (int x = 1; x <= n; x++) {
				int info = Integer.parseInt(inputs[x - 1]);
				if (info == STORE) {
					storeList.add(new Pos(y, x));
				} else if (info == HOUSE) {
					houseList.add(new Pos(y, x));
				}
			}
		}
	}

	public void selectStore(List<Pos> candidates, int cur) {
		if (candidates.size() == m) {
			//printCnadidate(candidates);
			minChickenDist = Math.min(minChickenDist, getChickenDist(candidates));
			return;
		}
		if (cur >= storeList.size()) {
			return;
		}

		for (int i = cur; i < storeList.size(); i++) {
			candidates.add(storeList.get(i));
			selectStore(candidates, i + 1);
			candidates.remove(storeList.get(i));
		}
	}

	public int getMinChickentDist() {
		List<Pos> candidates = new ArrayList<>();
		selectStore(candidates, 0);
		return minChickenDist;
	}

	public int getChickenDist(List<Pos> candidates) {
		int distSum = 0; // 치킨 거리 합계
		for (Pos house : houseList) {
			int dist = Integer.MAX_VALUE;
			for (Pos store : candidates) {
				dist = Math.min(dist, (Math.abs(house.getY() - store.getY()) + Math.abs(house.getX() - store.getX())));
			}
			//System.out.println(house.getY()+", "+house.getX() + " : " + dist);
			distSum += dist;
		}
		return distSum;
	}
}

class Pos {
	private int y;
	private int x;

	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
}

class IOUtils {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static String readInput() throws IOException {
		return br.readLine();
	}

	public static void writeOutput(int output) throws IOException {
		bw.write(output + "\n");
		bw.flush();
	}
}
