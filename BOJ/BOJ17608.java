import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main
{
	public static void main(String[] args) {
	    try {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	int n = Integer.parseInt(br.readLine());
	    	int[] stickArr = new int[n + 1];
	    	int lastStick = 0;
	    	for (int i = 0; i < n; i++) {
	    	    int stick = Integer.parseInt(br.readLine());
	    	    stickArr[i] = stick;
	    	    if (i == n - 1) {
	    	        lastStick = stick;
	    	    }
	    	}
	    	
	    	int cnt = 1;
	    	int maxLength = lastStick;
	    	for (int i = n-1; i >= 0; i--) {
	    	    if (stickArr[i] > maxLength) {
	    	        maxLength = stickArr[i];
	    	        cnt += 1;
	    	    }
	    	}
	    	System.out.println(cnt);
	    } catch(IOException e) {
	    
	    }
	}
}
