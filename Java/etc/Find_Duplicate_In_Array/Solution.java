/*
Given a read only array of n + 1 integers between 1 and n,
find one number that repeats in linear time using less than O(n) space and 
traversing the stream sequentially O(1) times.
*/
import java.util.*;
public class Solution {

    public static int repeatedNumber(final List<Integer> a) {
        int result = -1;
        int n = a.size();
        int[] nums = new int[a.size()];

        for(int i = 0 ; i < n; i++ ){
            int val = a.get(i);
            if(nums[val] == 0){ //
                nums[val] = (-1)*val;
            } else {
                result =  val;
                break;
            }
        }
        return result;
    }
        public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        List<Integer> sample = new ArrayList<Integer>();
        sample.add(3); sample.add(4); sample.add(1); sample.add(4); sample.add(1);
        System.out.println(repeatedNumber(sample));
        scan.close();
    }
}
