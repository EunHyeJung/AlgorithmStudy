import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 *  @date : 2020-04-05
 *  @source : https://www.acmicpc.net/problem/1043
 *  @email : ehye826@gamil.com
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        boolean[] isKnowingTruth = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        inputs = br.readLine().split(" ");
        if (Integer.parseInt(inputs[0]) > 0) {
            for (int i = 1; i < inputs.length; i++) {
                isKnowingTruth[Integer.parseInt(inputs[i])] = true;
                queue.add(Integer.parseInt(inputs[i]));
            }
        }

        List<Integer>[] participants = (List<Integer>[]) new List[m];
        Set<Integer>[] connectedInfo = (Set<Integer>[]) new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            connectedInfo[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            participants[i] = new ArrayList<>();
            inputs = br.readLine().split(" ");
            int numOfParticipants = Integer.parseInt(inputs[0]);
            for (int j = 1; j <= numOfParticipants; j++) {
                participants[i].add(Integer.parseInt(inputs[j]));
            }
            for (int j = 0; j < participants[i].size(); j++) {
                for (int k = j; k < participants[i].size(); k++) {
                    if (j != k) {
                        int participant1 = participants[i].get(j);
                        int participant2 = participants[i].get(k);
                        connectedInfo[participant1].add(participant2);
                        connectedInfo[participant2].add(participant1);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (connectedInfo[cur].size() > 0) {
                for (int connect : connectedInfo[cur]) {
                    if (!isKnowingTruth[connect]) {
                        isKnowingTruth[connect] = true;
                        queue.add(connect);
                    }
                }
            }
        }

        int cnt = m;
        for (int i = 0; i < m; i++) {
            for(int participant : participants[i]) {
                if (isKnowingTruth[participant]) {
                    cnt -= 1;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
