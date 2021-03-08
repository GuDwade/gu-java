public class 重建二叉树 {
    int idx ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0){
            return  null;
        }
        idx = 0;
        TreeNode root = build(preorder,inorder,0,inorder.length - 1);
        return  root;
    }

    private TreeNode build(int[] preorder, int[] inorder,  int inLeft, int inRight) {
        if (inLeft > inRight){
            return null;
        }

        int val = preorder[idx++];
        TreeNode root = new TreeNode(val);
        if (inLeft == inRight){
            return  root;
        }

        int find = -1 ;
        for(int i = inLeft; i <= inRight; i++){
            if (inorder[i] == val){
                find = i;
                break;
            }
        }

        root.left = build(preorder,inorder,inLeft,find - 1);
        root.right = build(preorder,inorder,find + 1,inRight);
        return  root;
    }


    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0){
            return  null;
        }

        TreeNode root = build(preorder,inorder,0,0,inorder.length - 1);
        return  root;
    }

    private TreeNode build(int[] preorder, int[] inorder, int idx , int inLeft, int inRight) {
        if (inLeft > inRight){
            return null;
        }

        int val = preorder[idx];
        TreeNode root = new TreeNode(val);
        if (inLeft == inRight){
            return  root;
        }

        int find = -1 ;
        for(int i = inLeft; i <= inRight; i++){
            if (inorder[i] == val){
                find = i;
                break;
            }
        }

        root.left = build(preorder,inorder,idx + 1, inLeft,find - 1);
        root.right = build(preorder,inorder,idx + find - inLeft + 1,find + 1,inRight);
        return  root;
    }
}


 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }