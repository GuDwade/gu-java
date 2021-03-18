public class 二叉树 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return root;
        }

        mirrorTree(root.left);
        mirrorTree(root.right);
        TreeNode tmp  = root.left;
        root.left = root.right;
        root.right = tmp;

        return  root;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null){
            return  false;
        }
        return isSameTree(A,B)
                || isSubStructure(A.left,B)
                || isSubStructure(A.right,B);
    }

    private boolean isSameTree(TreeNode A, TreeNode B) {
        if (A == null){
            return  true;
        }

        if (B == null){
            return false;
        }

        return  A.val == B.val
                && isSameTree(A.left,B.left)
                && isSameTree(A.right,B.right);
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return  true;
        }

        return  is_Symmetric(root.left,root.right);
    }

    private boolean is_Symmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null){
            return  left == null && right == null;
        }

        return  left.val == right.val
                &&is_Symmetric(left.left,right.right)
                &&is_Symmetric(left.right,right.left);
    }
}
