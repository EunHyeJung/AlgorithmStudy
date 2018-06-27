import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * acmicpc 1158.조세퍼스 문제
 * @author EunHyeJung
 * @date 2018.06.25
 * @link https://www.acmicpc.net/problem/1158
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		List<Integer> numList = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			numList.add(i);
		}

		int idx = 0;
		StringBuffer res = new StringBuffer("<");
		int size = numList.size();

		while (size > 0) {
			idx = (idx + (m - 1)) % size;
			res.append(numList.get(idx) + ", ");
			numList.remove(idx);
			size = numList.size();
		}
		
		res.delete(res.length()-2, res.length());
		res.append(">");
		System.out.println(res);
	}
}
