import java.util.ArrayList;
import java.util.List;


public class 二叉树中和为某一值的路径 {
    List<List<Integer>>ret;
    List<Integer>path;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        dfs(root,sum);
        return ret;
    }

    private void dfs(TreeNode root, int sum) {
        if(root==null){
            return;
        }

        path.add(root.val);
        sum-=root.val;
        if (sum==0&&root.left==null&&root.right==null){
            ret.add(new ArrayList<>(path));
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        path.remove(path.size()-1);
    }
}
