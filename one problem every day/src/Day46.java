import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day46 {
    //二叉树的右视图
    //BFS
    List<Integer>list=new ArrayList<>();
    public List<Integer> rightSideView0(TreeNode root) {
        bfs(root,0);
        return  list;
    }
    private void bfs(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if (depth==list.size()){
            list.add(root.val);
        }
        depth++;
        bfs(root.right,depth);
        bfs(root.left,depth);
    }

    //DFS
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer>list=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);

        while (queue.isEmpty()){
            int size=queue.size();
            while (size>0){
                TreeNode node=queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                if (size==1){
                    list.add(node.val);
                }
                size--;
            }
        }
        return  list;
    }
}
