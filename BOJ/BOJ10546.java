/*
* @source : https://www.acmicpc.net/problem/10546
* @author : EunHyeJung
* @email : ehye826@gmail.com
* @date : 2019-10-16
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class Main
{
	public static void main(String[] args) {
	    try {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		int n = Integer.parseInt(br.readLine());
    		
    	    Map<String, Integer> map = new HashMap<>();
    	    for (int i = 0; i < n; i++) {
    	        String name = br.readLine();
    	        map.put(name, map.getOrDefault(name, 0) + 1);
    	    }
    	    for (int i = 0; i < n-1; i++) {
    	        String name = br.readLine();
    	        if (map.get(name) -1 == 0){
    	            map.remove(name);
    	            continue;
    	        }
    	        map.put(name, map.get(name) - 1);
    	        
    	    }
    	    
    	    for(String name : map.keySet()){
    	        if(map.get(name) > 0) {
    	            System.out.println(name);
    	            return;
    	        }
    	    }
    	    
    	    
	    } catch(IOException e) {
	        
	    }
	}
}
