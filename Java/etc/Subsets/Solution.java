/*
If S = [1,2,3], a solution is:
[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
Each subset should in a ascending order.
*/

import java.util.*;
public class Solution {

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Collections.sort(a);
        int n = a.size();
         ArrayList<Integer> b = new ArrayList<Integer>();
         subsets(result, a, b, 0);
        //System.out.println(result.toString());
        return result;
    }

    private static void subsets(ArrayList<ArrayList<Integer>> sets, ArrayList<Integer> a, ArrayList<Integer> b, int idx){
        if(idx == a.size() || b.size() == a.size()) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(b);
            sets.add(temp);
            //System.out.println(temp.toString());
            return;
        } else {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(b);
            sets.add(temp);
           // System.out.println(temp.toString());
        }

        for(int i = idx; i < a.size(); i++){
            b.add(a.get(i));
            subsets(sets, a, b, i+1 );
            b.remove(b.size()-1);
        }
    }
    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); list.add(2); list.add(3);
        System.out.println(subsets(list));
        scan.close();
    }
}
