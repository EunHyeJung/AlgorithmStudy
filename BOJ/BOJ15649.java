import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
* @source https://www.acmicpc.net/problem/15649
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.27
*/
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            new BojSolution().solveProblem(n, m);
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }
}
class BojSolution {
    boolean[] chk = null;
    public void solveProblem(int n, int m) {
        chk = new boolean[n + 1];
        int[] res = new int[m];
        printNum(n, m, 0, res);
    }
    public void printNum(int n, int m, int idx, int[] res) {
       if (idx == m) {
            System.out.println(Arrays
                    .stream(res)
                    .mapToObj(String::valueOf)
                    .reduce((a, b) -> a.concat(" ").concat(b))
                    .get());
           return;
       }
       for(int i = 1; i <= n; i++) {
           if (chk[i])
               continue;
           chk[i] = true;
           res[idx] = i;
           printNum(n, m , idx + 1, res);
           chk[i] = false;
       }
    }
}
