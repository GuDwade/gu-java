import java.util.Stack;

public class ConvertBST {
    private int sum=0;
    //递归
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            root.val+=sum;
            sum=root.val;
            convertBST(root.left);
        }
        return root;
    }

    //迭代
    public TreeNode convertBST1(TreeNode root) {
        if(root==null){
            return root;
        }
        Stack<TreeNode>stack=new Stack<>();
        TreeNode node=root;
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.right;
            }
            //左边为空 栈顶元素已经为最大
            node=stack.pop();
            node.val+=sum;
            sum=node.val;
            //右 根 左
            if(node.left!=null){
                node=node.left;
            }else{
                node=null;
            }
        }
        return root;
    }

}
