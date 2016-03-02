public class Solution {
  private static class Node {
    String key;
    int val;
    Node left;
    Node right;
    
    public Node(String _key, int _val) {
      key = _key;
      val = _val;
    }
  }
  
  private static Node put(String key, int val, Node top) {
    Node cur = top;
    
    while(cur != null) {
      if (cur.key == key) {
        cur.val = val;
        return cur;
      } else if (key.compareTo(cur.key) < 0) {
        if (cur.left == null) {
          cur.left = new Node(key, val);
          return cur.left;
        }
        cur = cur.left;
      } else {
        if (cur.right == null) {
          cur.right = new Node(key, val);
          return cur.right;
        }
        cur = cur.right;
      }
    }

    return null;
  }
  
  private static Node putRecursive(String key, int val, Node cur) {
    if (cur == null) return new Node(key, val);

    if (key.compareTo(cur.key) < 0) {
      cur.left = putRecursive(key, val, cur.left);  
    } else if (key.compareTo(cur.key) > 0) {
      cur.right = putRecursive(key, val, cur.right);
    } else {
      cur.val = val;
    }
    
    return cur;
  }

  private static Node get(String key, Node top) {
    Node cur = top;
    while(cur != null) {
      if (cur.key == key) {
        return cur;
      } else if (key.compareTo(cur.key) < 0) {
        cur = cur.left;
      } else {
        cur = cur.right;
      }
    }
    return null;
  }
  
  private static Node floor(String key, Node top) {
    int com = key.compareTo(top.key);
    if (com == 0) {
      return top;
    } else if (com < 0) {
      if (top.left != null) {
        return floor(key, top.left);  
      } else {
        return top;
      }
    } else {
      if (top.right != null) {
        return floor(key, top.right);
      } else {
        return top;
      }
    }
  }
  
  private static int valuesSum(Node top) {
    if (top == null) return 0;
    return top.val + valuesSum(top.left) + valuesSum(top.right);
  }
  
  private static void printTree(Node n, String prefix) {
    System.out.println(prefix + " : key: " + n.key + "; val: " + n.val);
    if (n.left != null) {
      printTree(n.left, prefix + prefix.charAt(0));
    }
    if (n.right != null) {
      printTree(n.right, prefix + prefix.charAt(0));
    }
  }
  
  private static Node delete(String key) {
    return null;
  }
  
  public static void main(String[] args) {
  }
}
