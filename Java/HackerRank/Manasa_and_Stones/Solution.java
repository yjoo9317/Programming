import java.util.*;

public class Solution {
	
	
	public static int T, N, a, b, count;
	
	public static int data[];
	public static int dif[];
	public static int result[];
	
	public static void sort(){
		for(int i = 0; i <= count; i++){
			for(int j =i+1; j <= count; j++){
				if(result[i] > result[j]){
					int temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
			}
		}
	}

	public static void func(int n, int pre)
	{
		if(n == 0){
			int val = 0;
			for(int i = 1; i < N; i++){
				val += dif[data[i]];
			}
			if(count == 0 && result[0] == 0)
				result[count] = val;
			else {
				boolean found = false;
				for(int i = 0; i <= count; i++){
					if(val == result[i]){
						found = true; break;
					}
				}
				if(!found){
					count++; result[count] = val;
				}
			}
			return;
		}

		for(int i = pre; i <= 2; i++){
			data[N-n] = i;
			func(n-1, i);
		}
	}

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		//System.setIn(new FileInputStream("c:\\input.txt"));
		
		Scanner scan = new Scanner(System.in);
		
		T = scan.nextInt();
		
		while(T > 0){
			N = scan.nextInt();
			a = scan.nextInt();
			b = scan.nextInt();
			count = 0;
			dif = new int[3];
			dif[1] = a;
			dif[2] = b;
			result = new int[1000000];
			data = new int[N+1];
			func(N-1, 1);
			sort();
			for(int i = 0; i <= count; i++){
				System.out.print(result[i] + " ");
			}
			System.out.println("");
				
			T--;
		}

		scan.close();

	}
	
}
