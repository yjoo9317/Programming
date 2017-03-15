import java.util.*;

public class Solution {
    public static Scanner scan;
    public static int [] input;
    public static int N, T, MAX;
    public static ArrayList<Integer> pi;
    
    
    public static int func_nonconti()
    {
        int negative_max = -987654321;
        MAX = 0;
    	for(int i = 0; i < N; i++){
    		if(input[i] > 0)
    			MAX += input[i];
            else {
                if(negative_max < input[i])
                    negative_max = input[i];
    	     }
    	}
        if(MAX == 0)
           MAX = negative_max;
    	return MAX;
    }
    
    public static int func_contiguous()
    {
    	int psum = 0;
    	MAX = psum = input[0];

    	for(int i = 1; i < N; i++){
    		int temp = psum + input[i];
    		psum = temp > input[i]? temp : input[i];
    		MAX = MAX > psum ? MAX : psum;
    	}
    	return MAX;
    }
    
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        //System.setIn(new FileInputStream("d://input.txt"));
    	scan = new Scanner(System.in);
    	T = scan.nextInt();
    	while(T > 0){
	    	N = scan.nextInt();
	    	input = new int[N];
	    	for(int i = 0; i <N ;i++){
	    		input[i] = scan.nextInt();
	    	}
	    	System.out.print(func_contiguous()+" ");
	    	System.out.println(func_nonconti());
	    	T--;
    	}
    	scan.close();
    	
    }
}
