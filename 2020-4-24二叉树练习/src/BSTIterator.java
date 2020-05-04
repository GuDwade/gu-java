import java.util.Stack;

class BSTIterator {
    //二叉搜索树迭代器

    Stack<TreeNode>stack;

    public BSTIterator(TreeNode root) {
        stack=new Stack<>();
        while (root!=null){
            stack.push(root);
            root=root.left;
        }
    }


    public int next() {
        TreeNode top=stack.pop();
        int res=top.val;
        TreeNode root=top.right;
        while (root!=null){
            stack.push(root);
            root=root.left;
        }
        return  res;
    }


    public boolean hasNext() {
        return stack.isEmpty();
    }
}
