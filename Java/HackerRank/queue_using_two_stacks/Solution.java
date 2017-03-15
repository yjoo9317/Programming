import java.util.*;

public class Solution {
    public static Scanner scan;
    public static int q;
    public static Stack<Integer> s1, s2;
    
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        //System.setIn(new FileInputStream("d://input.txt"));
    	scan = new Scanner(System.in);
    	s1 = new Stack<Integer>();
    	s2 = new Stack<Integer>();
    	
    	q = scan.nextInt();
    	int command = -1;
    	while(q > 0){
    		command = scan.nextInt();
    		if(command == 1){
    			int val = scan.nextInt();
    			s1.push(val);
    		}
    		else if(command == 2){
    			if(!s2.isEmpty()){
    				s2.pop();
    			}
    			else {
    				while(!s1.isEmpty()){
    					s2.push(s1.pop());
    				}
    				s2.pop();
    			}
    		}
    		else if(command == 3){
    			if(s2.isEmpty()){
    				while(!s1.isEmpty())
    					s2.push(s1.pop());
    			}
    			System.out.println(s2.peek());
    		}
    		q--;
    	}
    	
    	scan.close();
    }
}
