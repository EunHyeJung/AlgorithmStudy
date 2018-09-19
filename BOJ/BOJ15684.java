import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/*
* @source https://www.acmicpc.net/problem/15684
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.09.19
*/
public class Main {
	public static void main(String[] args) {
		try {
			LadderManipulation ladderManipulation = new LadderManipulation();
			ladderManipulation.findMinInstallLineCnt();
		} catch (IOException e) {

		}
	}
}

class LadderManipulation {
	private static final int MAX_CNT = 3;
	private int n, m, h;
	private List<Integer>[] hLineList; // 가로줄리스트
	private boolean[][] isInstalled;
	private int[] nodes;
	private List<Line> installList; // 설치가능한 가로줄 리스트
	private int minCnt; // 최소 설치 개수 

	public LadderManipulation() throws IOException {
		this.init();
	}

	public void init() throws IOException {
		String[] inputs = IOUtils.readInput().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		h = Integer.parseInt(inputs[2]);

		hLineList = (List<Integer>[]) new List[h + 1];
		for (int i = 1; i <= h; i++) {
			hLineList[i] = new ArrayList<>();
		}
		isInstalled = new boolean[h + 1][n + 1]; // b -> b+1 가 h 높이에 있으면 체크
		installList = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			inputs = IOUtils.readInput().split(" ");
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);
			hLineList[a].add(b);
			isInstalled[a][b] = true; // a : 높이 
		}
		nodes = new int[n + 1];
		minCnt = Integer.MAX_VALUE;
	}

	// 가로줄 설치가 가능한 곳을 리스트에 담는 함수 
	public void findInstallSpot() {
		for (int height = 1; height <= h; height++) {
			for (int sp = 1; sp < n; sp++) {
				// 가로선이 접하거나 인접하지 않는 경우 설치리스트에 담아줌. sp : startpoint(가로선  설치 구간 : sp ~ sp+1)  
				if (isPossibleInstall(height, sp)) {
					installList.add(new Line(height, sp));
				}
			}
		}
	}

	public void findMinInstallLineCnt() throws IOException {
		if (getResult()) {
			IOUtils.writeOutput(0);
			return;
		}

		findInstallSpot();
		installHorizontalLine(0, 1);
		if (minCnt == Integer.MAX_VALUE) {
			IOUtils.writeOutput(-1);
			return;
		}
		IOUtils.writeOutput(minCnt);

	}

	public boolean isPossibleInstall(int height, int sp) {
		return !isInstalled[height][sp - 1] && !isInstalled[height][sp] && !isInstalled[height][sp + 1];
	}

	public void installHorizontalLine(int idx, int cnt) throws IOException {
		if (cnt > MAX_CNT) {
			return;
		}

		for (int i = idx, n = installList.size(); i < n; i++) {
			Line line = installList.get(i);
			int sp = line.getStartPoint();
			int height = line.getHeight();

			if (isPossibleInstall(height, sp)) {
				hLineList[height].add(sp);
				isInstalled[height][sp] = true;
				if (getResult()) {
					minCnt = Math.min(minCnt, cnt);
				}
				installHorizontalLine(i + 1, cnt + 1);
				isInstalled[height][sp] = false;
				hLineList[height].remove(new Integer(sp));
			}

		}
	}



	// 사다리 타기 결과를 가져옴. 
	public boolean getResult() {
		initNode();
		for (int i = 1; i <= h; i++) {
			// 현재 높이에서 가로선이 있는지 확인
			if (!hLineList[i].isEmpty()) {
				for (int line : hLineList[i]) { // 가로선이 존재하는것임
					int spot1 = line;
					int spot2 = line + 1;
					for (int no = 1; no <= n; no++) {
						// 가로선에 의해 옮겨질 노드가 있는지 확인
						if (nodes[no] == spot1 || nodes[no] == spot2) {
							nodes[no] = (nodes[no] == spot1) ? spot2 : spot1;
						}
					}
				}
			}
		}
		return isCorrect();

	}

	public void initNode() {
		for (int no = 1; no <= n; no++) {
			nodes[no] = no;
		}
	}
	
	public boolean isCorrect() {
		for (int no = 1; no <= n; no++) {
			if (nodes[no] != no) {
				return false;
			}
		}
		return true;
	}
}

class Line {
	private int height;
	private int startPoint;

	public Line(int height, int startPoint) {
		this.height = height;
		this.startPoint = startPoint;
	}

	public int getHeight() {
		return height;
	}

	public int getStartPoint() {
		return startPoint;
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

	public static void writeOutput(String output) throws IOException {
		bw.write(output + "\n");
		bw.flush();
	}
}
