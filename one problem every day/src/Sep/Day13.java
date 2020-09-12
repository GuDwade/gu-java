package Sep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day13 {
    //二叉树的层平均值
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>ret=new ArrayList<>();
        if (root==null){
            return  ret;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty()){
            int sz=queue.size();
            Double sum=0.0;
            for(int i=0;i<sz;i++){
                TreeNode cur=queue.poll();
                sum+=cur.val;
                if (cur.left!=null){
                    queue.add(cur.left);
                }
                if (cur.right!=null){
                    queue.add(cur.right);
                }
            }
            ret.add(sum/sz);
        }
        return  ret;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}