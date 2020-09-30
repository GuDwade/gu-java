package Sep;

public class Day30 {
    //二叉搜索树中的插入操作
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return  new TreeNode(val);
        }

        TreeNode cur=root;
        TreeNode par=null;

        while (cur!=null){
            par=cur;
            if (cur.val<val){
                cur=cur.right;
            }else if(cur.val>val){
                cur=cur.left;
            }
        }

        if (par.val>val){
            par.left=new TreeNode(val);
        }

        if (par.val<val){
            par.right=new TreeNode(val);
        }

        return  root;
    }
}
