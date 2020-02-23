import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    //前序遍历 逆序输出  头插
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer>ouput=new LinkedList<>();
        Stack<TreeNode>stack=new Stack<>();
        if(root==null){
            return ouput;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            ouput.addFirst(node.val);
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }
        }
        return ouput;
    }
    //一个栈实现前序遍历，另一个栈将前序的序列反转为后序
    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode>stack1=new Stack<>();
        Stack<Integer>stack2=new Stack<>();
        if(root==null){
            return stack2;
        }
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode tmp=stack1.pop();
            if(tmp!=null){
                stack2.push(tmp.val);
                stack1.push(tmp.left);
                stack1.push(tmp.right);
            }
        }
        LinkedList<Integer>list=new LinkedList<>();
        while(!stack2.isEmpty()){
            list.add(stack2.pop());
        }
        return list;
    }
}
