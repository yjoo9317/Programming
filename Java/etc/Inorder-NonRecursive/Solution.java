public class Solution {
	public ArrayList<Integer> inorderTraversal(TreeNode a) {
        if(a == null)
            return null;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Hashtable<TreeNode, Integer> visited = new Hashtable<>();
        TreeNode current = a;
        while(true){
            if(current.left != null && !visited.containsKey(current.left)){
                stack.push(current);
                current = current.left;
                continue;
            }
            result.add(current.val);
            if(!visited.containsKey(current)){
                visited.put(current, 1);
            }
            if(current.right != null){
                current = current.right;
                continue;
            } else {
                if(!visited.containsKey(current))
                    visited.put(current, 1);
                if(stack.isEmpty()) break;
                current = stack.pop();
                continue;
            }
        }
        return result;
	}
}
