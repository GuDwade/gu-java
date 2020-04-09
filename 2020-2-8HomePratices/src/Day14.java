import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Day14 {
    //二叉树的右视图
    //BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>list=new LinkedList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int num=queue.size();
            while (num>0){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if (num==1){
                    list.add(node.val);
                }
                num--;
            }
        }

        return list;
    }
    //DFS
    List<Integer>list=new ArrayList<>();
    public List<Integer> rightSideView1(TreeNode root) {
        dfs(root,1);
        return list;
    }
    public void dfs(TreeNode node,int depth){
        if(node==null){
            return;
        }
        if(depth>list.size()){
            list.add(node.val);
        }
        dfs(node.right,depth+1);
        dfs(node.left,depth+1);
    }

}
