import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class LeetcodePra {
    List<Integer> list=new LinkedList<>();
    //前序遍历递归
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return list;
        } else if(root!=null){
            list.add(root.val);
        }
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
    //中序遍历递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return list;
        }else if (root!=null){
            inorderTraversal(root.left);
        }
        list.add(root.val);
        inorderTraversal(root.right);
        return  list;
    }
    //后序遍历递归
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return list;
        }else if (root!=null){
            postorderTraversal(root.left);
        }
        postorderTraversal(root.right);
        list.add(root.val);
        return  list;
    }
}
