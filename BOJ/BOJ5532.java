import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int L = Integer.parseInt(br.readLine());
		double A = Double.parseDouble(br.readLine());
		double B = Double.parseDouble(br.readLine());
		double C = Double.parseDouble(br.readLine());
		double D = Double.parseDouble(br.readLine());

		bw.write((int) (L - Math.max(Math.ceil(A / C), Math.ceil(B / D))) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
