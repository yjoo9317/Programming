

  static int prev = -1;
  boolean checkBST(Node root) {
      if(root == null) return true;

      if(!checkBST(root.left)) return false;
      if(root.data <= prev) return false;
      prev = root.data;
      if(!checkBST(root.right)) return false;
      return true;
  }
