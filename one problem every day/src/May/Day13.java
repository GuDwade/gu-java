package May;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day13 {
    //层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if (root==null){
            return  res;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer>list=new ArrayList<>();
            while (size>0){
                TreeNode tmp=queue.poll();
                list.add(tmp.val);
                if (tmp.left!=null){
                    queue.offer(tmp.left);
                }
                if (tmp.right!=null){
                    queue.offer(tmp.right);
                }
                size--;
            }
            res.add(new ArrayList<>(list));
        }

        return  res;
    }
}
