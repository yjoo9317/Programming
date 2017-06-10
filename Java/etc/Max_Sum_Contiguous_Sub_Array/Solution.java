import java.util.*;
public class Solution {

    public static int maxSubArray(final List<Integer> a){
        int max = -987654321;
        int sum = -987654321;
        int ret = -987654321;
        int [] amax = new int[a.size()];
        for(int i = 0; i < a.size(); i++){
            int val = a.get(i);
            sum = max + val;
            max = getMax(sum, val);
            if(ret < max){
                ret = max;
            }
        }
        return ret;
    }

    private static int getMax(int a, int b){
        return a > b ? a : b;
    }

    public static void main(String[] args) {
	// write your code here
        List<Integer> sample = new ArrayList<Integer>();
        sample.add(-2); sample.add(1); sample.add(-3); sample.add(4); sample.add(-1);
        sample.add(2); sample.add(1); sample.add(-5); sample.add(4);
        System.out.println(maxSubArray(sample));

    }
}
