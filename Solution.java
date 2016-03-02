class Solution { 
  static class Node {
    int val;
    Node left;
    Node right;
    
    Node(int val) {
      this.val = val;
    }
  }
  
  static Node fillIn(int[] ar) {
    return fillIn(ar, 0, ar.length - 1);
  }
  
  static Node fillIn(int[] ar, int l, int r) {
    int m = (l + r) / 2;
    
    Node n = null;
    if (l <= r) {
      n = new Node(ar[m]);
      n.left = fillIn(ar, l, m - 1);
      n.right = fillIn(ar, m + 1, r);
    }    
    return n;
  }
  
  static void printOutBFS(Node n) {
    Queue<Node> q = new LinkedList<Node>();
    q.add(n);
    printOutBFS(q);
  }
  
  static void printOutBFS(Queue<Node> q) {
    int s = q.size();
    Node n = null;
    
    /*
    while(q.size() != 0) {
      n = q.remove();
      System.out.print(n != null ? " " + n.val : " -");
      if (n != null) {
        q.add(n.left);
        q.add(n.right);
      }      
    }
    */
    
    for (int i = 0; i < s; i++) {
      n = q.remove();
      System.out.print(n != null ? " " + n.val : " -");
      if (n != null) {
        q.add(n.left);
        q.add(n.right);
      }
    }

    if (q.size() > 0) {
      System.out.println();
      printOutBFS(q);
    }
  }
  
  static void printOutDFS(Node n) {   
    if (n == null) return;
    System.out.print(" " + n.val);
    printOutDFS(n.left);
    printOutDFS(n.right);
  }

  public static void main(String[] args) {
    int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    Node n1 = fillIn(a);
    printOutBFS(n1);
    System.out.println();
    printOutDFS(n1);
  }
}
