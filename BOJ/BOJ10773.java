import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
    @Date : 2019-11-07 Thu
    @Source : https://www.acmicpc.net/problem/10773
    @author : ehye826@gmail.com
*/
public class Main
{
	public static void main(String[] args) {
	    try {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	int n = Integer.parseInt(br.readLine()), sum = 0;
	    	Stack<Integer> numStack = new Stack<>();
	    	
	       for (int i = 0; i < n; i++) {
	           int num = Integer.parseInt(br.readLine());
	           if (num != 0) {
	               sum += num;
	               numStack.push(num);
	           } else {     // num == 0
	               sum -= (numStack.isEmpty() ? 0 : numStack.pop());
	           }
	       }
	       System.out.println(sum);
	    } catch(IOException e) {
	    
	    }
	    
	}
}
