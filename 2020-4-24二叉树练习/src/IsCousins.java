public class IsCousins {
    int xDep,yDep;
    TreeNode xPar,yPar;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root.left, 1, x, y, root);
        dfs(root.right, 1, x, y, root);
        return xDep==yDep&&xPar!=yPar;
    }

    public void dfs(TreeNode node, int dep, int x, int y, TreeNode par) {

        if (node == null) {
            return;
        }

        if (node.val==x){
            xDep=dep;
            xPar=par;
        }else if (node.val==y){
            yDep=dep;
            yPar=par;
        }else{
            dfs(node.left,dep+1, x, y, node);
            dfs(node.right,dep+1,x, y, node);
        }

    }
}
