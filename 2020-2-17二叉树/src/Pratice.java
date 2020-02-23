import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Pratice {
    //前序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>list=new LinkedList<>();
        Stack<TreeNode>stack=new Stack<>();
        if(root==null){
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp=stack.pop();
            list.add(tmp.val);
            if(tmp.right!=null){
                stack.push(tmp.right);
            }
            if(tmp.left!=null){
                stack.push(tmp.left);
            }
        }
        return list;
    }
    //中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        List<Integer>list=new LinkedList<>();
        if (root==null){
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp=stack.pop();
            if(tmp!=null){
                stack.push(tmp.right);
                stack.push(tmp);
                stack.push(tmp.left);
            }else if(!stack.isEmpty()){
                list.add(stack.pop().val);
            }
        }
        return list;
    }
    //后序遍历
    public static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        LinkedList<Integer>list=new LinkedList<>();
        if (root==null){
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp=stack.pop();
            list.addFirst(tmp.val);
            if(tmp.left!=null){
                stack.push(tmp.left);
            }
            if(tmp.right!=null){
                stack.push(tmp.right);
            }
        }
        return  list;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode n1=new TreeNode(2);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(4);
        TreeNode n4=new TreeNode(3);
        TreeNode n5=new TreeNode(3);
        TreeNode n6=new TreeNode(4);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.left=n5;
        n2.right=n6;
        System.out.println(preorderTraversal(root));
        System.out.println(inorderTraversal(root));
        System.out.println(postorderTraversal(root));
    }
}
