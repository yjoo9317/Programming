import java.util.*;
public class Solution {

    private static ArrayList<String> list;
    private static int[] index;
    public static void func(String needle, String haystack){
        int n = haystack.length();
        index = new int[n];
        getList(needle);
        //System.out.println("list size: "+list.size());
        for(String s : list){
            getIndex(s, haystack);
        }
        for(int i = 0; i < n; i++){
            if(index[i] > 0)
                System.out.print(i+" ");
        }
    }
    private static void getIndex(String needle, String haystack){
        int n = haystack.length();
        int m = needle.length();

        for(int i = 0; i < n; i++){
            if(needle.charAt(0) == haystack.charAt(i) && i+m <= n){
                if(needle.equals(haystack.substring(i, i+m))){
                    //System.out.println(haystack.substring(i, i+m));
                    index[i] = 1;
                }
            }
        }
    }
    private static void getList(String s){
        char [] result = s.toCharArray();
        doTheRest(result, result.length);

    }
    private static void doTheRest(char[] result, int n){
        if(n == 1){
            list.add(new String(result));
            return;
        }
        for(int i = 0; i < n; i++){
            swap(result, i, n -1);
            doTheRest(result, n -1);
            swap(result, i, n-1);
        }
    }

    private static void swap(char[] a, int i, int j){
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        list = new ArrayList<String>();
        func("ab", "bbbbababba");
        scan.close();
    }
}
