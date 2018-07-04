import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Sherlock and Anagrams
 * 
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2018.07.04
 * @link https://www.hackerrank.com/challenges/sherlock-and-anagrams/submissions/code/77061680
 */


public class Solution {

    // Complete the sherlockAndAnagrams function below.
    public static final int ALPHABET_CNT = 26;

    static boolean isAnagrams(String s1, String s2) {

        char[] chCnt1 = new char[ALPHABET_CNT];
        char[] chCnt2 = new char[ALPHABET_CNT];


        for (int i = 0, n = s1.length(); i < n; i++) {
            chCnt1[s1.charAt(i) - 97] += 1;
            chCnt2[s2.charAt(i) - 97] += 1;
        }

        for (int i = 0; i < ALPHABET_CNT; i++) {
            if (chCnt1[i] != chCnt2[i]) {
                return false;
            }
        }

        return true;
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int cnt = 0;
        for (int i = 1, n = s.length(); i < n; i++) {
            List<String> subsetList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i + j <= n) {
                    subsetList.add(s.substring(j, i + j));
                }
            }

            for (int k = 0, size = subsetList.size(); k < size; k++) {
                for (int l = k + 1; l < size; l++) {
                    if (isAnagrams(subsetList.get(k), subsetList.get(l))) {
                        cnt++;
                    }
                }
            }
        }


        return cnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
