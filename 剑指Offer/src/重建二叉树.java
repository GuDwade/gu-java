public class 重建二叉树 {
    //前序与中序
    int curIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        curIdx=0;
        return buildTreeHelp(preorder,inorder,0,inorder.length-1);
    }

    private TreeNode buildTreeHelp(int[] preorder, int[] inorder, int start, int end) {
        if (start>end){
            return null;
        }
        int val=preorder[curIdx++];
        TreeNode root=new TreeNode(val);
        if (start==end){
            return root;
        }
        int i;
        for(i=start;i<=end;i++){
            if (inorder[i]==val){
                break;
            }
        }
        root.left=buildTreeHelp(preorder,inorder,start,i-1);
        root.right=buildTreeHelp(preorder, inorder, i+1, end);
        return  root;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        curIdx=postorder.length-1;
        return _buildTree(inorder,postorder,0,postorder.length-1);
    }


    private TreeNode _buildTree(int[] inorder, int[] postorder, int start, int end) {
        if (start>end){
            return null;
        }
        int val=postorder[curIdx--];
        TreeNode root=new TreeNode(val);
        if (start==end){
            return root;
        }
        int i;
        for(i=start;i<=end;i++){
            if (inorder[i]==val){
                break;
            }
        }
        root.right=_buildTree(inorder, postorder, i+1, end);
        root.left=_buildTree(inorder, postorder, start, i+1);
        return  root;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
