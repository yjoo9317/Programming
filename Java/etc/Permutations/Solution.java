
import java.util.*;
public class Solution {

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        permute(result, a, a.size());
        return result;
    }

    private static void permute(ArrayList<ArrayList<Integer>> result, ArrayList<Integer>b, int n){
        if(n ==1){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(b);
            result.add(temp);
        }
        for(int i = 0; i < n; i++){
            swap(b, i, n-1);
            permute(result, b, n-1);
            swap(b, i, n-1);
        }
    }

    private static void swap(ArrayList<Integer> a, int i, int j){
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }


    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); list.add(2); list.add(3);
        System.out.println(permute(list));
        scan.close();
    }
}
