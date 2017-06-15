import java.util.*;

public class Solution {
    public static ArrayList<String> group;
    public static void func(String[][] input){
        group = new ArrayList<String>();
        int max = 0;
        int n = input.length;
        for(int i = 0; i < n; i++){
            int m = input[i].length;
            int idx = i +1;

            group.addAll(Arrays.asList(input[i]));
            for(int j = 0; j < group.size(); j++){
                String s = group.get(j);
                boolean result = false;
                for(int k = idx; k < n; k++){
                    result = isAssociated(s, input[k]);
                    if(result){
                        addItem(group, input[k]);
                    }
                }
            }
            if(max < group.size())
                max = group.size();
            System.out.println(group.toString());
            group.clear();
        }
        System.out.println(max);
    }

    private static void addItem(ArrayList<String> list, String[] a){
        int n = a.length;
        for(int i =0; i < n; i++){
            if(!list.contains(a[i]))
                list.add(a[i]);
        }
    }

    private static boolean isAssociated(String s, String[] a){
        boolean result = false;
        int n = a.length;
        for(int i = 0; i < n; i++){
            if(s.equals(a[i])){
                result = true; break;
            }

        }
        return result;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[][] sample = {{"item1", "item2"}, {"item2", "item3", "item4"}, {"item5", "item6"}, {"item3", "item7"}};
        func(sample);
        scan.close();
    }
}
