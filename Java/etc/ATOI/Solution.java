import java.util.*;
public class Solution {

    public static int atoi(final String a){
        long ret = 0;
        StringBuffer sb = new StringBuffer();
        boolean started = false;
        boolean unary = false;
        boolean isNegative = false;
        for(int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            if(c == ' ' && unary && !started) return 0;  //e.g., + 34
            if(c == ' ' && !started) continue;
            else if(c == '-' && !started){ // e.g., 123 45
                started = true;
                unary = true; isNegative = true; continue;
            }
            else if(c =='+' && !started){
                started = true;
            }
            else if(c == ' ') break;
            else if(c >= '0' && c <='9') {
                if(!started) started = true;
                sb.append(c);
            }
            else break; // 678D345 -> 678 
        }
        String str = sb.toString();
        System.out.println(str);
        int n = str.length();
        long digit = 1;
        boolean isBeyond = false;
        for(int i = n-1; i >= 0; i--){
            ret += (str.charAt(i)-'0')*digit;
            digit *= 10;
            if(digit > Integer.MAX_VALUE) {
                isBeyond = true; break;
            }
        }
        if(ret > Integer.MAX_VALUE || isBeyond){
            //System.out.println("beyond max");
            if(isNegative) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }

        if(isNegative)
            return (int)(-1*ret);
        return (int)ret;
    }
    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        System.out.println(atoi("-88297 248252140B12 37239U4622733246I218 9 1303 44 A83793H3G2 1674443R591 4368 7 97"));
        scan.close();
    }
}
