/*
* @source https://www.acmicpc.net/problem/15650
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.30
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) {
       try {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           String[] inputs = br.readLine().split( " ");
           int n = Integer.parseInt(inputs[0]);
           int m = Integer.parseInt(inputs[1]);
           int[] nums = new int[n];
           for (int i = 0; i < n; i++)
               nums[i] = i + 1;
           new Solution().backtrack(nums, new ArrayList<>(), m, n, 0);
        } catch(Exception e) {
        }
    }
}




class Solution {
    public void backtrack(int[] nums, List<Integer> curList, int m, int n, int start) {
       if (curList.size() == m) {
            for (int num : curList)
                System.out.print(num + " ");
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            curList.add(nums[i]);
            backtrack(nums, curList, m, n, i + 1);
            curList.remove(curList.size() - 1);
        }
    }
}
