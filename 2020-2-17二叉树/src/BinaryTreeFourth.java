public class BinaryTreeFourth {
    //相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    //另一个树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        if(isSameTree(s,t)){
            return true;
        }else if(isSubtree(s.left,t)){
            return true;
        }else if(isSubtree(s.right,t)){
            return true;
        }
        return false;
    }
    //最大深度
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return left>=right?1+left:1+right;
    }
    //平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root!=null){
            int left=maxDepth(root.left);
            int right=maxDepth(root.right);
            if(Math.abs(left-right)<2){
                if (isBalanced(root.left)&&isBalanced(root.right)){
                    return true;
                }
                return false;
            }
            return false;
        }else{
            return true;
        }
    }
    //对称二叉树
    public boolean _isSymmetric(TreeNode left,TreeNode right ) {
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        return left.val==right.val
                &&_isSymmetric(left.left,right.right)
                &&_isSymmetric(left.right,right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root!=null){
            return _isSymmetric(root.left,root.right);
        }
        return true;
    }
}
