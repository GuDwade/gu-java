package August;

public class Day18 {
	//二叉树的最小深度
    public int minDepth(TreeNode root) {
       if(root==null){
           return 0;
       }

       if (root.left==null&&root.right==null){
           return 1;
       }

       int left=minDepth(root.left);
       int right=minDepth(root.right);

       return  left==0||right==0?1+right+left:1+Math.min(left,right);
    }
}
