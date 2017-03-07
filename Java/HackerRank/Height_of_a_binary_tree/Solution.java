/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	static int height(Node root) {
      	// Write your code here.
        if(root == null) return -1;
        int ret = max(height(root.left), height(root.right));
        return ret+1;
    }

    static int max(int a, int b){
        return a > b ? a: b;
    }
