import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/*
* @source https://www.acmicpc.net/problem/2890
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2019.10.18
*/
public class Main
{
    
    public static int team_cnt = 9;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		int r = Integer.parseInt(inputs[0]);
		int c = Integer.parseInt(inputs[1]);
		
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		for(int i = 0; i < r; i++) {
		    char[] info = br.readLine().toCharArray();
		    int cur = 1;
		    
		    while (cur < c-1 && info[cur] == '.') {
		        cur += 1;
		    }
		    if(info[cur] != 'F') {
		        int score = c-4-cur;
		        if (!map.containsKey(score)) {
		            map.put(score, new ArrayList<Integer>());
		        }
		        map.get(score).add((int) info[cur] - 49);
		    }
		}
		int ranking = 1;
		int[] teamRanking = new int[9];
		for (int remain : map.keySet()) {
		    List<Integer> res = map.get(remain);
		    for(int teamNo : res) {
		        teamRanking[teamNo] = ranking;
		    }
		    ranking += 1;
		}
		
		for  (int teamNo = 0; teamNo < 9; teamNo++) {
	    	bw.write(teamRanking[teamNo] + "\n");
		}
		
        bw.flush();		
		bw.close();
		br.close();
	}
}
