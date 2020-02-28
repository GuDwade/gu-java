import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    public static boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            //一直入队  直到为空停下
            if(node==null){
                break;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        //若后面结点全为空则是完全二叉树
        //只要出现不为空的即不是
        while(!queue.isEmpty()){
            if(queue.poll()!=null){
                return  false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root=BinaryTreeCon.buildTree();
        System.out.println(isCompleteTree(root));
    }
}
