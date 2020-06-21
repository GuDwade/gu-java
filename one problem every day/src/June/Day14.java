package June;

public class Day14 {
    //二叉树中的最大路径和

    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfsPath(root);
        return  max;
    }

    private int dfsPath(TreeNode root) {
        if (root==null){
            return  0;
        }

        int left=dfsPath(root.left);
        int right=dfsPath(root.right);
        max=Math.max(max,root.val+left+right);
        return Math.max(0,root.val+Math.max(left,right));
    }
}
