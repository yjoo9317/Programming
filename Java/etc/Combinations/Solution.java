import java.util.*;
public class Solution {

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        combine(result, a, n, k, 1);
        return result;
    }

    private static void combine(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> a, int n, int k, int idx){
        if(a.size() == k){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(a);
            result.add(temp);
            return;
        }
        for(int i = idx; i <= n; i++){
            a.add(i);
            combine(result, a, n, k, i+1);
            a.remove(a.size()-1);
        }
    }

    public static void main(String[] args) {
    	// write your code here
        Scanner scan = new Scanner(System.in);
        //ArrayList<Integer> list = new ArrayList<Integer>();
        //list.add(1); list.add(2); list.add(3);
        System.out.println(combine(4, 2));
        scan.close();
    }
}
