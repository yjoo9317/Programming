public class Solution {
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
        if(a == null)
            return null;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Hashtable<TreeNode, Integer> table = new Hashtable<>();
        TreeNode current = a;
        while(true){
            if(!table.containsKey(current)){
                table.put(current, 1);
                result.add(current.val);
                //stack.push(current);
            }
            if(current.left != null && !table.containsKey(current.left)){
                stack.push(current);
                current = current.left;
                continue;
            }
            if(current.right != null){
                current = current.right;
                
                continue;
            }
            else {
                if(stack.isEmpty())
                    break;
                current = stack.pop();
            }
        }

        return result;
	}
}
