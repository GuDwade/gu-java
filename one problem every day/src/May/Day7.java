package May;

public class Day7 {
    //另一个树的子树

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        if(isSameTree(s,t)){
            return true;
        }

        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }


    private boolean isSameTree(TreeNode s,TreeNode t){
        if(s==null||t==null){
            return s==null&&t==null;
        }

        return s.val==t.val&&isSameTree(s.left,t.left)&&isSameTree(s.right,t.right);
    }
}
