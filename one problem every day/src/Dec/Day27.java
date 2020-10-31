package Dec;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day27 {
    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>ret =new ArrayList<>();
        Stack<TreeNode> stack =new Stack<>();

        if(root ==null){
            return  ret;
        }

        TreeNode cur=root;

        while (cur!=null||!stack.isEmpty()){

            while (cur!=null){
                ret.add(cur.val);
                stack.push(cur);
                cur=cur.left;
            }

            cur=stack.pop();
            cur=cur.right;
        }

        return  ret;


    }
}
