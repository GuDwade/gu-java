package Dec;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class Day12 {
    //二叉搜索树的最小绝对差
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
                return  0;
        }

        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;
        List<Integer> list=new ArrayList<>();

        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }

            cur=stack.pop();
            list.add(cur.val);
            cur=cur.right;
        }

        int min=Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++){
            min=Math.min(min,list.get(i+1)-list.get(i));
        }
        return  min;
    }
}
