import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/*
* @source https://www.acmicpc.net/problem/11586
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.12.10
*/
class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    char[][] data = new char[n][n];
    for (int i = 0; i < n; i++) {
      data[i] = br.readLine().toCharArray();
    }
    int state = Integer.parseInt(br.readLine());
    
    printMirror(n, data, state);
  }
  
  public static void printMirror(int n, char[][] data, int state) {
    switch(state) {
      case 1: {
        for (int i = 0; i < n; i++) {
          for(int j = 0; j < n; j++) {
            System.out.print(data[i][j]);
          }
          System.out.println();
        }
        return;
      } case 2: {
        for (int i = 0; i < n; i++) {
          for(int j = n - 1; j >= 0; j--) {
            System.out.print(data[i][j]);
          }
          System.out.println();
        }
        return;
      } case 3: {
        for (int i = n - 1; i >= 0; i--) {
          for(int j = 0; j < n; j++) {
            System.out.print(data[i][j]);
          }
          System.out.println();
        }
        return;
      }
        
    }
  }
}
