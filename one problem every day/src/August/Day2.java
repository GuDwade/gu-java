package August;

import java.util.Stack;

public class Day2 {
    //二叉树展开为链表
    public void flatten(TreeNode root) {
        if (root==null||(root!=null&&root.left==null&&root.right==null)){
            return ;
        }
        TreeNode prev=null;
        Stack<TreeNode>stack=new Stack<>();
        stack.push(root);

        while (stack.isEmpty()){
            TreeNode cur=stack.pop();
            if (prev!=null){
                prev.left=null;
                prev.right=cur;
            }
            if (cur.right!=null){
                stack.push(cur.right);
            }
            if (cur.left!=null){
                stack.push(cur.left);
            }
            prev=cur;
        }

    }

    public  void prevOrder(TreeNode root){
        if (root==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;

        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){
                System.out.print(cur.val+" ");
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            cur=cur.right;
        }
        System.out.println();
    }

    public  void inOrder(TreeNode root){
        if (root==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;

        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            System.out.print(cur.val+" ");
            cur=cur.right;
        }
        System.out.println();
    }

    public  void postOrder(TreeNode root){
        if (root==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;
        TreeNode prev=null;

        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.peek();
            if (cur.right==null||cur.right==prev){
                System.out.print(cur.val+" ");
                stack.pop();
                prev=cur;
                cur=null;
            }else{
                cur=cur.right;
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        Day2 test=new Day2();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        node1.left=node2;
        node1.right=node5;
        node2.left=node3;
        node2.right=node4;
        node5.right=node6;
        test.prevOrder(node1);
        test.inOrder(node1);
        test.flatten(node1);
        test.postOrder(node1);
        test.prevOrder(node1);
    }
}
