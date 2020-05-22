package May;

public class Day20 {
    //从前序与中序遍历序列构造二叉树
    int curIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        curIdx=0;
        return _buildTree(preorder,inorder,0,inorder.length-1);
    }

    private TreeNode _buildTree(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if(inStart>inEnd){
            return null;
        }

        int val=preorder[curIdx++];
        TreeNode root=new TreeNode(val);
        if (inStart==inEnd){
            return root;
        }

        int idx;
        for(idx=inStart;idx<=inEnd;idx++){
            if (inorder[idx]==val){
                break;
            }
        }

        root.left=_buildTree(preorder, inorder, inStart, idx-1);
        root.right=_buildTree(preorder, inorder, idx+1, inEnd);

        return  root;
    }
}
