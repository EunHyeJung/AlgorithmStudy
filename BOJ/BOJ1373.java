import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		BinaryConverter binaryConverter = new BinaryConverter(br.readLine());
		bw.write(binaryConverter.convertToOct());
		bw.flush();
		bw.close();
		br.close();
	}

}

class BinaryConverter {

	private Map<String, Integer> map;
	private String input;
	private int n;

	public BinaryConverter(String input) {
		this.input = input;
		this.n = input.length();
		map = new HashMap<>();
		map.put("000", 0);
		map.put("001", 1);
		map.put("010", 2);
		map.put("011", 3);
		map.put("100", 4);
		map.put("101", 5);
		map.put("110", 6);
		map.put("111", 7);
	}

	public String convertToOct() {
		int i = n - 1;
		StringBuilder res = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		while (i >= 0) {
			sb.insert(0, input.charAt(i));
			if (sb.length() == 3) {
				res.append(getOctValue(sb));
				sb = new StringBuilder();
			}
			i--;
		}
		if (sb.length() > 0) {
			res.append(getOctValue(sb));
		}

		return res.reverse().toString();
	}

	public int getOctValue(StringBuilder sb) {
		while (sb.length() < 3) {
			sb.insert(0, "0");
		}
		return map.get(sb.toString());
	}
}
