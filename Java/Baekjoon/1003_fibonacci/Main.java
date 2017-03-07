import java.util.*;
   
public class Main {
    
    public static Scanner scan;
    public static int[][] table;
    
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
    	scan = new Scanner(System.in);
    	int T = scan.nextInt();
    	
    	table = new int[41][2];
    	
    	table[0][0] = 1;
    	table[0][1] = 0;
    	table[1][0] = 0;
    	table[1][1] = 1;
    	
    	for(int i = 2; i <= 40; i++){
    		table[i][0] = table[i-1][0]+table[i-2][0];
    		table[i][1] = table[i-1][1]+table[i-2][1];
    	}
    	while(T > 0){
    		int N = scan.nextInt();
    		System.out.println(table[N][0]+ " "+table[N][1]);
    		T--;
    	}
    	
    	scan.close();
    	
    }
  
}
