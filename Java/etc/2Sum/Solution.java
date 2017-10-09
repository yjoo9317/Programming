public class Solution {
	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        Hashtable<Integer, ArrayList<Integer>> table = new Hashtable<>();
        int max = a.size();
        for(int i = 0; i < a.size(); i++){
            int val = a.get(i);
            if(table.containsKey(val)){
                table.get(val).add(i);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                table.put(val, temp);
            }
        }
        for(int i = 0; i < a.size(); i++){
            int val = a.get(i);
            int dif = b -val;
            if(table.containsKey(dif)){
                int index1 = i;
                int index2 = -1;
                if(val == dif && table.get(dif).size() == 1) continue;
                else if(val == dif && table.get(dif).size() > 1)
                    index2 = table.get(dif).get(1);
                else index2 = table.get(dif).get(0);

                if(index1 > index2 || index1 == index2) continue;
                if(index2 >= max) continue;
                result.clear();
                index1++; index2++;
                result.add(index1);
                result.add(index2);
                max = index2-1;
            }
        }
        return result;
	}
}
