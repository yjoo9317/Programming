/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
ex: ["12", "14", "+"] -> 26 
*/

import java.util.*;
public class Solution {

    public static int evalRPN(ArrayList<String> a){
        int ret = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : a){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                ret = getResult(stack, s.charAt(0));
                stack.push(ret);
            } else if(s.charAt(0) == '-' ){
                ret = toInt(s.substring(1, s.length()));
                ret *= -1;
                stack.push(ret);
            } else if(s.charAt(0) == '+'){
                ret = toInt(s.substring(1, s.length()));
                stack.push(ret);
            }
            else if(!isExpression(s)){
                ret = toInt(s);
                stack.push(ret);
            } else {
                int last = 0;
                for(int i = 0; i < s.length(); i++){
                    char c = s.charAt(i);
                    if(c == '+' || c == '-' || c =='*' || c =='/'){
                        int val = toInt(s.substring(last, i));
                        last = i+1;
                        stack.push(val);
                        ret = getResult(stack, c);
                        stack.push(ret);
                    }
                }
            }
        }
        return ret;
    }

    public static int getResult(Stack<Integer> stack, char op){
        int op2 = stack.pop();
        int op1 = stack.pop();

        if(op == '+')
            return op1+op2;
        else if(op =='*')
            return op1*op2;
        else if(op =='-')
            return op1 - op2;
        else return op1/op2;
    }

    public static boolean isExpression(String s){
        int n = s.length();
        for(int i = 0; i < n ; i++){
            char c = s.charAt(i);
            if(c == '+' || c == '-' || c =='*' || c =='/'){
                return true;
            }
        }
        return false;
    }

    public static int toInt(String s){
        int digit = 1;
        int n = s.length();
        int ret = 0;
        for(int i = n -1; i >=0; i--){
            char c = s.charAt(i);
            int val = c - '0';
            ret += digit*val;
            digit *= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        //System.out.println(braces("(a)"));
        ArrayList<String> list = new ArrayList<String>();
        list.add("-1");
        /*list.add("13");
        list.add("23");
        list.add("+");
        list.add("*");
        list.add("3+");*/
        System.out.println(evalRPN(list));
        scan.close();
    }
}
