import java.io.*;


public class Solution {
	
	public static int N, M;
	
	public static int[] C; // coins
	public static int[] data;
	public static int[] dirty;
	public static int count;
	public static int idx = 0;
	
	public static void func(int n, int c, int idx)
	{
		if(n == 0){
			count += 1;
			return;
		}
		else if( n < 0) return;
		
		for(int  i = c; i < M; i++){
			data[idx] = C[i];
			func(n - C[i], i, idx+1);
			if(n - C[i] == 0 || n-C[i] < 0) break;
		}
	}
	
	public static long dynamic() {
		long[][] solution = new long[M + 1][N + 1];

		// if amount=0 then just return empty set to make the change
		for (int i = 0; i <= M; i++) {
			solution[i][0] = 1;
		}

		// if no coins given, 0 ways to change the amount
		for (int i = 1; i <= N; i++) {
			solution[0][i] = 0;
		}

		// now fill rest of the matrix.

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				// check if the coin value is less than the amount needed
				if (C[i - 1] <= j) {
					// reduce the amount by coin value and
					// use the subproblem solution (amount-v[i]) and
					// add the solution from the top to it
					solution[i][j] = solution[i - 1][j]
							+ solution[i][j - C[i - 1]];
				} else {
					// just copy the value from the top
					solution[i][j] = solution[i - 1][j];
				}
			}
		}
		return solution[M][N];
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner scan = new Scanner(System.in);
		 
		 N = scan.nextInt();
		 M = scan.nextInt();
		 
		 C = new int[M];
		 data = new int[N+1];
		 dirty = new int[N+1];
		 
		 for(int i = 0; i < M; i++){
			 C[i] = scan.nextInt();
		 }
		 
		 System.out.println(dynamic());
		 
		 scan.close();
	}

}

