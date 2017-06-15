import java.util.*;

public class Solution {

    public static String add(String a, String b){
        StringBuffer sb = new StringBuffer();

        int n = a.length();
        int m = b.length();
        int i = n-1;
        int j = m - 1;
        boolean carry = false;
        while(i >= 0 && j >= 0){
            int x = a.charAt(i)-'0';
            int y = b.charAt(j)-'0';
            int sum = x + y;
            if(sum == 2){
                if(carry)
                    sum = 1;
                else {
                    carry = true;
                    sum = 0;
                }
            } else if(sum == 1){
                if(carry)
                    sum = 0;
            } else if(sum == 0){
                if(carry) {sum = 1; carry = false;}

            }
            sb.append(sum);
            j--; i--;
        }
        while( i >= 0){
            int x = a.charAt(i) - '0';
            if(carry){
                if(x == 1)
                    x= 0;
                else {
                    carry = false;
                    x = 1;
                }
            }
            sb.append(x); i --;
        }
        while( j >= 0){
            int y = b.charAt(j) - '0';
            if(carry){
                if(y == 1) y = 0;
                else {
                    carry = false;
                    y = 1;
                }
            }
            sb.append(y); j --;
        }
        if(carry)
            sb.append(1);
        sb.reverse();
        return sb.toString();
    }

    private static int max(int a, int b){
        return a > b ? a : b;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println(add("11", "111"));
        scan.close();
    }
}
