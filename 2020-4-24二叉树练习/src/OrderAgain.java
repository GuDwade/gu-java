import java.util.*;

public class OrderAgain {

    public List<Integer>  preorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();

        TreeNode cur=root;

        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                list.add(cur.val);
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            cur=cur.right;
        }

        return  list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();

        TreeNode cur=root;

        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }

            cur=stack.pop();
            list.add(cur.val);
            cur=cur.right;
        }

        return  list;

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();

        TreeNode cur=root;
        TreeNode prev=null;

        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.peek();
            if (cur.right==null||cur.right==prev){
                list.add(cur.val);
                prev=cur;
                stack.pop();
                cur=null;
            }else{
                cur=cur.right;
            }
        }

        return  list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if (root==null){
            return  null;
        }

        Queue<TreeNode>que=new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()){
            int sz=que.size();
            List<Integer>list=new ArrayList<>();
            while (sz>0){
                TreeNode node=que.poll();
                if (node.left!=null){
                    que.offer(node.left);
                }
                if (node.right!=null){
                    que.offer(node.right);
                }
                list.add(node.val);
                sz--;
            }
            res.add(list);
        }

        return  res;
    }
}

