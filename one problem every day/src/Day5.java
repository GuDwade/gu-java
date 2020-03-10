class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Day5 {
    //二叉树的最大直径
    //max表示以当前结点为根的最大直径
    public int maxLen=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        depth(root);
        return maxLen;
    }
    public int depth(TreeNode root) {
        if(root==null){
            return  0;
        }
        int left=depth(root.left);
        int right=depth(root.right);
        //当前结点的直径  root的直径 = root左子树高度 + root右子树高度
        maxLen=Math.max(left+right,maxLen);
        //返回当前结点的高度
        return Math.max(left,right)+1;
    }

}
