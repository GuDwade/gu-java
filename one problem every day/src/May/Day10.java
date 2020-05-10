package May;

import java.util.Stack;

public class Day10 {
    //二叉树的最近公共祖先
    //记录搜索路径
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q){
            return root;
        }

        Stack<TreeNode>stack1=new Stack<>();
        Stack<TreeNode>stack2=new Stack<>();

        getPath(root,p,stack1);
        getPath(root,q,stack2);

        while (stack1.size()!=stack2.size()){
            if (stack1.size()>stack2.size()){
                stack1.pop();
            }else{
                stack2.pop();
            }
        }

        while (stack1.peek()!=stack2.peek()){
            stack1.pop();
            stack2.pop();
        }
        return  stack1.peek();
    }

    private boolean getPath(TreeNode root, TreeNode node ,Stack<TreeNode>stack) {
         if (root==null){
             return  false;
         }

         stack.push(root);
         if (root==node){
             return  true;
         }

         if (getPath(root.left,node,stack)){
             return  true;
         }

          if (getPath(root.right,node,stack)){
            return  true;
         }

         stack.pop();
         return  false;

    }

    //判断是否在通一边
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q){
            return root;
        }

        boolean pL=false,pR=false,qL=false,qR=false;

        if(find(root.left,p)){
            pL=true;
        }else{
            pR=true;
        }

        if(find(root.left,q)){
            qL=true;
        }else{
            qR=true;
        }

        if(pL&&qL){
            return lowestCommonAncestor(root.left,p,q);
        }else if(pR&&qR){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }

    private boolean find(TreeNode root,TreeNode node){
        if(root==null){
            return false;
        }

        if(root==node){
            return true;
        }

        if(find(root.left,node)){
            return true;
        }

        return find(root.right,node);
    }
}
