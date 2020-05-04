public class Problems {
    //二叉树的剪枝
    public TreeNode pruneTree(TreeNode root) {
        if (root==null){
            return  null;
        }
        boolean left=contain(root.left);
        boolean right=contain(root.right);

        if (left==false){
            root.left=null;
        }
        if (right==false){
            root.right=null;
        }

        pruneTree(root.left);
        pruneTree(root.right);

        return  root;
    }

    private boolean contain(TreeNode root){
        if (root==null){
            return  false;
        }

        if (root.val==1){
            return  true;
        }

        if (contain(root.left)){
            return  true;
        }

        return  contain(root.right);
    }

    //最大二叉树
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return  buildTree(nums,0,nums.length-1);
    }

    private TreeNode buildTree(int[]nums,int start,int end){
        if (start>end){
            return  null;
        }

        int maxIdx=start;
        int max=nums[start];
        for(int i=start+1;i<=end;i++){
            if (nums[i]>max){
                max=nums[i];
                maxIdx=i;
            }
        }

        TreeNode root=new TreeNode(max);
        root.left=buildTree(nums,start,maxIdx-1);
        root.right=buildTree(nums,maxIdx+1,end);
        return  root;
    }

    //二叉搜索树剪枝
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null){
            return root;
        }

        //小于最小值  左子树全部不符合
        if (root.val < L){
            return trimBST(root.right, L, R);
        }
        //大于最大值  右子树也都大于
        if (root.val > R){
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    //直径
    int maxLen;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return  maxLen;
    }

    private int  dfs(TreeNode root) {
        if(root==null){
            return  0;
        }

        int left=dfs(root.left);
        int right=dfs(root.right);
        maxLen=Math.max(maxLen,left+right);
        return  Math.max(left,right)+1;
    }

    //最大路径和
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfsPath(root);
        return  max;
    }
    //返回从root向下走的最大路径和
    private int dfsPath(TreeNode root) {
        if (root==null){
            return  0;
        }

        int left=dfs(root.left);
        int right=dfs(root.right);
        max=Math.max(max,root.val+left+right);
        return Math.max(0,root.val+Math.max(left,right));
    }

}
