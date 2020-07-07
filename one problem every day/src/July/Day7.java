package July;

import java.util.Stack;

public class Day7 {
    //路径总和

    //迭代
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return sum-root.val==0;
        }

        TreeNode cur=root;
        TreeNode prev=null;
        Stack<TreeNode>stack=new Stack<>();
        int target=0;



        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                target+=cur.val;
                stack.push(cur);
                cur=cur.left;
            }

            cur=stack.peek();
            if (cur.right==null&&cur.left==null&&target==sum){
                return true;
            }
            if (cur.right==null||cur.right==prev){
                target-=cur.val;
                prev=cur;
                stack.pop();
                cur=null;
            }else{
                cur=cur.right;
            }
        }

        return false;
    }


    //递归
    public boolean hasPathSum1(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return sum-root.val==0;
        }
        return hasPathSum(root.left,sum-root.val)
                ||hasPathSum(root.right,sum-root.val);
    }
}
