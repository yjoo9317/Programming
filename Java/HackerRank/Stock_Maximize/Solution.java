import java.io.*;


public class Solution {
	
	public static int T, N;
	public static long[] P;
	public static int m;
	public static int s;
	public static long cost = 0; // cost to buy the shares
	public static int count = 0; // number of share bought
	public static long []R; 

	
	public static void findMax(int begin)
	{
		long max = 0;
		for(int i = begin; i < N; i++){
			if(max < P[i]){
				max = P[i];
				m = i;
				s = i;
			}
		}
	}
	
	public static void func()
	{
		for(int i = 0; i < N; i++){
			if( i == m){
				findMax(i+1);
				cost += P[i] * count;
				if(cost < 0) cost = 0; //never worked out so far.
				count = 0; // reset the count
			}
			else if(i < s){
				cost -= P[i];
				count +=1;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner scan = new Scanner(System.in);
		 T = scan.nextInt();
		 int t = T;
		 R = new long[T];
		 while(t > 0){
			 N = scan.nextInt();
			 P = new long[N+1];
			 long max = 0;
			 count = 0;
			 cost  = 0;
			 for(int i = 0; i < N; i++){
				 P[i] = scan.nextInt();
				 if(max < P[i]){
					 max = P[i];
					 m = i;
					 s = i;
				 }
			 }
			 func();
			 if(cost < 0) R[T-t] = 0; 
			 else R[T-t] = cost;
			 t-= 1;
		 }
		 for(int i = 0; i <T; i++)
			 System.out.println(R[i]);
		 
		 scan.close();
	}

}
