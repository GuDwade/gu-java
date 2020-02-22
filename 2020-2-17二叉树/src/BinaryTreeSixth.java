import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeSixth {
    ///根据后序和中序构建二叉树
    public static int curIndex;
    public TreeNode _buildTree(int[] inorder,int[] postorder, int inStart,int inEnd) {
        if(inStart>inEnd){
            return null;
        }
        int rootVal=postorder[curIndex--];
        TreeNode root=new TreeNode(rootVal);
        if(inStart==inEnd){
            return root;
        }
        int i;
        for(i=inStart;i<=inEnd;i++){
            if(rootVal==inorder[i]){
                break;
            }
        }
        root.right=_buildTree(inorder,postorder,i+1,inEnd);
        root.left=_buildTree(inorder,postorder,inStart,i-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        curIndex=postorder.length-1;
        return _buildTree(inorder,postorder,0,inorder.length-1);
    }
    //非递归实现二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        List<Integer>list=new ArrayList<>();
        if (root==null){
            return list;
        }
        stack.push(root);
        while(stack.size()>0){
            TreeNode node=stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return list;
    }
    //右根左入栈 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        List<Integer>list=new ArrayList<>();
        if (root==null){
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.peek();
            stack.pop();
            if(node!=null){
                stack.push(node.right);
                stack.push(node);
                stack.push(node.left);
            }else if(!stack.isEmpty()){
                list.add(stack.pop().val);
            }
        }
        return list;
    }
    //使结点一直指向根的左边 直到左边为空 根入队 结点再指向根右边
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        List<Integer>list=new ArrayList<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            list.add(root.val);
            root=root.right;
        }
        return  list;
    }
}
