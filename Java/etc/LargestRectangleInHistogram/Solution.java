
import java.util.*;

public class Solution {
    public static int largestRectangleArea(ArrayList<Integer> a) {
        Stack<Integer> stack = new Stack<Integer>();
        int max_rect = 0;
        int area = 0;
        int i = 0 ;
        int n = a.size();
        while(i < n ){
            if(stack.isEmpty() || a.get(stack.peek()) <= a.get(i)){
                stack.push(i++);
            } else {
                int top = stack.pop();
                int h = a.get(top);
                if(stack.isEmpty()){
                    area = h * i;
                } else{
                    int R = i;
                    int L = stack.peek();
                    area = h * (R-L-1);
                }
                max_rect = max(max_rect, area);
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            int h = a.get(top);
            if(stack.isEmpty()){
                area = h * i;
            } else {
                int R = i;
                int L = stack.peek();
                area = h * (R-L-1);
            }
            max_rect = max(max_rect, area);
        }

        return max_rect;
    }

    private static int max(int a, int b){
        return a > b? a : b;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<Integer>();
        //a.add(2); a.add(1); a.add(5); a.add(6); a.add(2); a.add(3);
        //a.add(5); a.add(4); a.add(3); a.add(2); a.add(1);
        //a.add(90); a.add(58); a.add(69); a.add(70); a.add(82); a.add(100);
        //a.add(13); a.add(57); a.add(47); a.add(18);
        a.add(2); a.add(1); a.add(5); a.add(6); a.add(2); a.add(3);
        System.out.println(largestRectangleArea(a));
        scan.close();
    }
}
