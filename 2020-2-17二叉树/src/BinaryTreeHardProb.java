public class BinaryTreeHardProb {
    public static TreeNode prev=null;
    //中序遍历将二叉搜索树排序 改变链表方向
    public void _Convert(TreeNode root) {
        if(root==null){
            return;
        }
        _Convert(root.left);
        root.left=prev;
        if(prev!=null){
            prev.right=root;
        }
        prev=root;
        _Convert(root.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        //重置 否则与上一次测试的树相连接
        prev=null;
        _Convert(pRootOfTree);
        //返回排序后的头节点 即左边为空的结点
        while( pRootOfTree.left!=null){
            pRootOfTree= pRootOfTree.left;
        }
        return  pRootOfTree;
    }
    public static int curIndex=0;
    public TreeNode _buildTree(int[] preorder, int[] inorder,int inStart,int inEnd) {
        if(inStart>inEnd){
            return null;
        }
        int rootVal=preorder[curIndex++];
        TreeNode root=new TreeNode(rootVal);
        if(inStart==inEnd){
            return root;
        }
        int i;
        for(i=inStart;i<=inEnd;i++){
            if(rootVal==inorder[i]){
                break;
            }
        }
        root.left=_buildTree(preorder,inorder,inStart,i-1);
        root.right=_buildTree(preorder,inorder,i+1,inEnd);
        return root;
    }
    //根据前序和中序构建二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        curIndex=0;
        return _buildTree(preorder,inorder,0,inorder.length-1);
    }

}
