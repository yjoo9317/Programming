
import java.util.*;
public class Solution {

    public static ArrayList<Integer> result;
    public static void plusOne(ArrayList<Integer> a){
        trim(a);
        int n = a.size();
        int val = a.get(n-1)+1;
        if(n == 1 && val == 10){
            a.set(0, 1); a.add(0);
            return;
        }
        if( val == 10){
            a.set(n-1, 0);
            for(int i = n-2; i >= 0; i--){
                if(addOne(a, i) > 0){
                    continue;
                } else break;
            }
        } else {
            a.set(n-1, val);
        }
        System.out.print(a.toString());
    }
    private static int addOne(ArrayList<Integer>a, int idx){
        int val = a.get(idx) + 1;
        if(idx == 0){
            if(val == 10){
                a.set(idx, 0);
                a.add(0, 1);
                return 1;
            } else {
                a.set(idx, val);
                return 0;
            }
        } else{
            if(val == 10){
                a.set(idx, 0);
                return 1;
            } else {
                a.set(idx, val);
                return 0;
            }
        }
    }

    private static void trim(ArrayList<Integer> a){
        int n = a.size();
        if( n == 1 && a.get(0) == 0) return;
        for(int i =0; i < n ; i++){
            if(a.get(i) != 0) return;
            else {
                a.remove(i);
                i = -1; n -= 1;
            }
        }
    }
    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        result = new ArrayList<Integer>();
        ArrayList<Integer> sample = new ArrayList<Integer>();
        //sample.add(1); sample.add(9); sample.add(9); sample.add(9);
        sample.add(9); sample.add(9);
        plusOne(sample);
        scan.close();
    }
}
