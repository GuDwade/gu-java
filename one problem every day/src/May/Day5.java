package May;

import java.util.Stack;

public class Day5 {
    //验证二叉搜索树

    //递归
    public boolean isValidBST(TreeNode root) {
        return  _isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean _isValidBST(TreeNode root, long min, long max) {
        if (root==null){
            return  true;
        }

        if (root.val<=min||root.val>=max){
            return  false;
        }

        return _isValidBST(root.left,min,root.val)&&_isValidBST(root.right,root.val,max);
    }

    //迭代
    public boolean isValidBST1(TreeNode root) {
        if (root==null){
            return  true;
        }

        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        long prev=Long.MIN_VALUE;

        while (cur!=null||!stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur=stack.pop();
            if (prev<cur.val){
                prev=cur.val;
            }else{
                return  false;
            }
            cur=cur.right;
        }

        return  true;
    }
}
