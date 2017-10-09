import java.util.*;
public class Solution {


    public static int colorful(int a){
        Hashtable<Integer, Integer> table = new Hashtable<>();
        String s = Integer.toString(a);
        int max = s.length()-1;
        int[] nums = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            nums[i] = s.charAt(i) - '0';
        }

        for(int i = 0; i < nums.length; i++){
            int product = 1;
            for(int j = 0; j <= max && i+j < nums.length; j++){
                product *= nums[i+j];
                if(table.get(product) != null)
                    return 0;
                else{
                    table.put(product, 1);
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
    	// write your code here
        Scanner scan = new Scanner(System.in);
        //ArrayList<Integer> list = new ArrayList<Integer>();
        //list.add(1); list.add(2); list.add(3);
        System.out.println(colorful(3245));
        scan.close();
    }

}
