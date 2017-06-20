import java.util.*;
public class Solution {

    public static int braces(String a){
        Stack<Character> stack = new Stack<Character>();
        int n = a.length();
        char prev = ' ';
        for(int i = 0 ; i < n; i++){
            char c = a.charAt(i);
            if(c != ')') {
                stack.push(c);
            } else if(c ==')'){
                boolean disconnected = false;
                int count = 0;
                while(true) {
                    char d = stack.pop();
                    if(d != '(') {
                        disconnected = true;
                        count++;
                    }
                    else if(d == '(') {
                        if(!disconnected || count == 1) return 1;
                        break;
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(braces("(a)"));
    }
}
