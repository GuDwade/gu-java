package Sep;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Day29 {
    //二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>list=new LinkedList<>();
        Stack<TreeNode>stack=new Stack<>();

        if(root==null){
            return list;
        }

        TreeNode cur=root;
        TreeNode prev=null;

        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }

            cur=stack.peek();
            if(cur.right==null||cur.right==prev){
                list.add(cur.val);
                prev=cur;
                stack.pop();
                cur=null;
            }else{
                cur=cur.right;
            }
        }

        return  list;
    }
}
