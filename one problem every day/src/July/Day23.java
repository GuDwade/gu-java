package July;

public class Day23 {
    //二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        int max=Math.max(left,right);
        return  max+1;
    }
}
