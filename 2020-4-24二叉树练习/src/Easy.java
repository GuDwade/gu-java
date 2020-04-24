import java.util.Stack;

public class Easy {
    //最大深度
    public int maxDepth(TreeNode root) {
        if(root==null){
            return  0;
        }
        if (root.left==null&&root.right==null){
            return  1;
        }

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    //平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return  true;
        }

        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        if (Math.abs(left-right)>1){
            return  false;
        }
        return  isBalanced(root.left)&&isBalanced(root.right);

    }

    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return  true;
        }
        return  is_Symmetric(root.left,root.right);
    }
    public boolean is_Symmetric(TreeNode left,TreeNode right){
        if (left==null||right==null){
            return  left==null&&right==null;
        }
        return  left.val==right.val
                &&is_Symmetric(left.right,right.left)
                &&is_Symmetric(left.left,right.right);
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root==null){
            return  true;
        }
        Stack<TreeNode>left=new Stack<>();
        Stack<TreeNode>right=new Stack<>();

        TreeNode l=root.left;
        TreeNode r=root.right;

        while (l!=null||r!=null||!left.isEmpty()||!right.isEmpty()){
            while (l!=null&&r!=null){
                left.push(l);
                l=l.left;
                right.push(r);
                r=r.right;
            }

            if (l!=null||r!=null){
                return  false;
            }

            l=left.pop();
            r=right.pop();
            if (l.val!=r.val){
                return  false;
            }
            l=l.right;
            r=r.left;
        }
        return  true;
    }

    //相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null){
            return  p==null&&q==null;
        }

        return p.val==q.val &&isSameTree(p.right,q.right)&&isSameTree(p.left,q.left);

    }
    //另一个树的子树
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null){
            return  false;
        }
        if (isSameTree(A,B)){
            return  true;
        }
        if (isSubStructure(A.left,B)){
            return  true;
        }
        if (isSubStructure(A.right,B)){
            return  true;
        }
        return  false;
    }
}
