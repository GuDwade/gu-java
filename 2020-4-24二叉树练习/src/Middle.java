import java.util.LinkedList;
import java.util.Queue;

public class Middle {
    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    public  static void levelOrder(TreeNode root){
        Queue<TreeNode>queue=new LinkedList<>();
        if (root==null){
            return;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            System.out.printf(node.val+" ");
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        System.out.println();
    }

    public  static  TreeNode buidTree(){
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        TreeNode n7=new TreeNode(7);
        TreeNode n8=new TreeNode(8);
        TreeNode n9=new TreeNode(9);
        n1.left=n2;
        n1.right=n3;
        n2.right=n5;


        n3.left=n6;

        return  n1;
    }

    public static void main(String[] args) {
        TreeNode tree=buidTree();
        levelOrder(tree);
        TreeNode newTree=invertTree(tree);
        levelOrder(newTree);
    }

}
