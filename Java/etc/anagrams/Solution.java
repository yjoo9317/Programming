import java.util.*;
public class Solution {

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] selected = new int[a.size()];
        int n = a.size();
        for(int i = 0; i < n; i++){
            if(selected[i] > 0) continue;
            String s = a.get(i);
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i+1); selected[i] = 1;
            ArrayList<Character> str1 = sort(s);
            for(int j = i+1;  j <n; j++){
                ArrayList<Character> str2 = sort(a.get(j));
                if(equals(str1, str2)){
                    temp.add(j+1);
                    selected[j] = 1;
                    //System.out.println("["+(i+1)+", "+(j+1)+"]");
                }
            }
            result.add(temp);
        }
        return result;
    }

    private static boolean equals(ArrayList<Character> a, ArrayList<Character> b){
        if(a.size() != b.size()) return false;
        for(int i = 0; i < a.size(); i++){
            if(a.get(i) != b.get(i))
                return false;
        }
        return true;
    }
    private static ArrayList<Character> sort(String a){
        char [] str = a.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for(char c : str){
            list.add(c);
        }
        Collections.sort(list);
        return list;
    }


    public static void main(String[] args) {
    	// write your code here
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        list.add("cat"); list.add("dog"); list.add("god"); list.add("tca");
        anagrams(list);
        scan.close();
    }

}
