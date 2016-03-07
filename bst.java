class BST {
  class Node {
      int val;
      Node left;
      Node right;

      public Node(int val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  private Node root;

  public void fillIn(int[] sa) {
      root = fillIn(sa, 0, sa.length - 1);
  }

  private Node fillIn(int[] sa, int l, int r) {
    int m = (r + l) / 2;
    Node n = null;
    if (l <= r) {
        n = new Node(sa[m], null, null);
        n.left = fillIn(sa, l, m - 1);
        n.right = fillIn(sa, m + 1, r);
    }
    return n;
  } 
  
  public void printDFS() {
    printDFS(root);
    System.out.println();
  }

  private void printDFS(Node c) {
    if (c != null) {
      System.out.print(c.val + " ");
      printDFS(c.left);
      printDFS(c.right);
    }
  }
  
  public void printBFS() {
    if (root == null) {
      return;
    }
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);
    printBFS(q);
  }

  private void printBFS(Queue<Node> q) {
    int s = q.size();
    for (int i = 0; i < s; i++) {
      Node n = q.remove();
      System.out.print((n == null ? "-" : n.val) + " ");
      if (n != null) {
        q.add(n.left);
        q.add(n.right);
      }
    }
    if (q.size() > 0) {
      System.out.println();
      printBFS(q);
    }
  }
}
