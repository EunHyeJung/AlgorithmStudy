import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  @date : 2020-03-19
 *  @source : https://www.acmicpc.net/problem/1388
 *  @email : ehye826@gamil.com
 * */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        boolean[][] chk = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!chk[i][j]) {
                    char curDecoration = board[i][j];
                    cnt += 1;
                    if (curDecoration == '-') {
                        int k = j;
                        while (k < m && board[i][k] == curDecoration){
                            chk[i][k] = true;
                            k += 1;
                        }
                    } else {    // curDecoration == '|'
                        int k = i;
                        while (k < n && board[k][j] == curDecoration) {
                            chk[k][j] = true;
                            k += 1;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
