import java.util.*;

public class Solution {
    
    public static Scanner scan;
    public static int N, M;
    public static int a, b, k;
    public static long MAX;
    public static long[] data;
    
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
    	scan = new Scanner(System.in);
    	
    	N = scan.nextInt();
    	M = scan.nextInt();
    	MAX = -987654321;
    	data = new long[N+1];
    	
    	for(int i = 0; i < M; i++){
    		a = scan.nextInt();
    		b = scan.nextInt();
    		k = scan.nextInt();
    		
    		data[a-1] += k;
    		data[b] -= k;
    	}
    	long sum = 0;
    	for(int i = 0; i < N; i++){
    		sum += data[i];
    		if(sum > MAX)
    			MAX = sum;
    	}
        
    	System.out.println(MAX);
    	scan.close();
    	
    }
   
}
