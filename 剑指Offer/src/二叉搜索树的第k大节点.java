import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉搜索树的第k大节点 {
    public static int kthLargest(TreeNode root, int k) {
        if(root==null){
            return  -1;
        }
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;

        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            list.add(cur.val);
            cur=cur.right;
        }

        return  list.get(list.size()-k);
    }
    //优化
    public static int kthLargest1(TreeNode root, int k) {
        if(root==null){
            return  -1;
        }
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;
        int ret=-1;
        int time=0;

        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){
                stack.push(cur);
                cur=cur.right;
            }
            cur=stack.pop();
            if(++time==k){
                ret=cur.val;
                break;
            }
            cur=cur.left;
        }

        return  ret;
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        node3.left=node2;
        node1.right=node5;
        node2.left=node1;
        node5.left=node4;
        node5.right=node6;
        System.out.println(二叉搜索树的第k大节点.kthLargest1(node1, 3));
    }
}
