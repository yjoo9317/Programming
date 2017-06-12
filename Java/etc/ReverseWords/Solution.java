import java.util.*;
public class Solution {


    public static String reverseWords(String a){
        StringBuffer sb = new StringBuffer();
        int n = a.length();
        if(n == 1 && a.charAt(0) != ' ')
            return a;
        int lastIndex = n-1;
        int i = n-1;
        while(a.charAt(i) == ' '){
            i--;
        }
        lastIndex = i;
        while(i >= 0){
            if(a.charAt(i) == ' '){
                if(sb.length() > 0)
                    sb.append(' ');
                sb.append(a.substring(i+1, lastIndex+1));
                i = findNext(a, i); lastIndex = i;
                continue;
            }  else i--;
        }
        if(lastIndex >= 0){
            if(sb.length() > 0)
                sb.append(' ');
            sb.append(a.substring(0, lastIndex+1));
        }
        return sb.toString();
    }

    public static int findNext(String a, int idx){
        for(int i = idx; i >= 0; i--){
            if(a.charAt(i) != ' ')
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        System.out.println(reverseWords("t si s f jkj dkd"));
        scan.close();
    }
}
