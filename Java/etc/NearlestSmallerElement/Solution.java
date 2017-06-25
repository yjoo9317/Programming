/*
*  Given an array, find the nearest smaller element G[i] for every element A[i] in the array 
*  such that the element has an index smaller than i.
*/
import java.util.*;
public class Solution {

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        int min = 987654321;
        for(int i : arr){
            if(buffer.isEmpty() || min > i) {
                result.add(-1);
                min = i;
            } else{
                boolean found = false;
                for(int j = buffer.size()-1; j >= 0; j--){
                    int val = buffer.get(j);
                    if(val < i) {
                        result.add(val);
                        found = true; break;
                    }
                }
                if(!found) result.add(-1);
            }
            buffer.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4); list.add(5); list.add(2); list.add(10);
        System.out.println(prevSmaller(list).toString());
        scan.close();
    }
}
