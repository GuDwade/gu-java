package Dec;

public class Day29 {

    //求根到叶子节点数字之和

    int sum=0;

    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return  sum;
    }

    private void dfs(TreeNode root,int cur) {

        if (root==null){
            return;
        }

        cur=cur*10+root.val;

        if (root.left==null&&root.right==null){
            sum+=cur;
            return;
        }

        dfs(root.left,cur);
        dfs(root.right,cur);


    }
}
