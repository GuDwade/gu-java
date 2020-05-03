public class BuildTree {
    int curIdx;
    //根据前序与中序构建二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        curIdx=0;
        return _buildTree(preorder,inorder,0,preorder.length-1);
    }
    //前序遍历确定根  中序确定根的左右区间
    private TreeNode _buildTree(int[] preorder, int[] inorder,int inStart,int inEnd) {
        if(inStart>inEnd){
            return  null;
        }

        int value=preorder[curIdx++];
        TreeNode root=new TreeNode(value);
        if (inStart==inEnd){
            return  root;
        }
        int i;
        for(i=inStart;i<=inEnd;i++){
            if (inorder[i]==value){
                break;
            }
        }
        root.left=_buildTree(preorder,inorder,inStart,i-1);
        root.right=_buildTree(preorder,inorder,i+1,inEnd);
        return  root;
    }

    //根据后序与中序构建二叉树
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        curIdx=postorder.length-1;
        return  _buildTree1(inorder,postorder,0,curIdx);
    }
    //先构造右子树  在构造左子树
    private TreeNode _buildTree1(int[] inorder, int[] postorder ,int inStart,int inEnd){
        if(inStart>inEnd){
            return  null;
        }

        int value=postorder[curIdx--];
        TreeNode root=new TreeNode(value);
        if (inStart==inEnd){
            return  root;
        }

        int i;
        for(i=inStart;i<=inEnd;i++){
            if (inorder[i]==value){
                break;
            }
        }

        root.right=_buildTree1(inorder,postorder,i+1,inEnd);
        root.left=_buildTree1(inorder,postorder,inStart,i-1);
        return  root;
    }
    public static void main(String[] args) {
        BuildTree tree=new BuildTree();
        int[]preorder = {3,9,20,15,7};
        int[]inorder = {9,3,15,20,7};
        TreeNode newTree=tree.buildTree(preorder,inorder);
    }
}
