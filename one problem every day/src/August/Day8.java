package August;

import java.util.Stack;

public class Day8 {
    //恢复二叉搜索树

    public void recoverTree(TreeNode root) {
        TreeNode first=null;
        TreeNode second=null;
        TreeNode prev=null;
        Stack<TreeNode>stack=new Stack<>();

        while(!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if (prev!=null&&root.val<prev.val){
                second=root;
                if (first==null){
                    first=prev;
                }else{
                    break;
                }
            }
            prev=root;
            root=root.right;
        }

        int tmp=first.val;
        first.val=second.val;
        second.val=tmp;

    }

}
