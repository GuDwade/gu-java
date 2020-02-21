import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeFifth {
    //层次遍历
   public static void levelOrderTraversal(TreeNode root){
       Queue<TreeNode>que=new LinkedList<>();
       if(root!=null){
           que.offer(root);
       }
       while(!que.isEmpty()){
           TreeNode tmp=que.poll();
           System.out.print(tmp.val+" ");
           if(tmp.left!=null){
               que.offer(tmp.left);
           }
           if(tmp.right!=null){
               que.offer(tmp.right);
           }
       }
       System.out.println();
   }

   public static TreeNode buildNodeTree(){
       TreeNode root=new TreeNode(3);
       TreeNode n1=new TreeNode(2);
       TreeNode n2=new TreeNode(2);
       TreeNode n3=new TreeNode(4);
       TreeNode n4=new TreeNode(3);
       TreeNode n5=new TreeNode(3);
       TreeNode n6=new TreeNode(4);
       root.left=n1;
       root.right=n2;
       n1.left=n3;
       n1.right=n4;
       n2.left=n5;
       n2.right=n6;
       return root;
   }
    public static Node buildTree(){
        Node root=new Node('A');
        Node n1=new Node('B');
        Node n2=new Node('C');
        Node n3=new Node('D');
        Node n4=new Node('E');
        Node n5=new Node('F');
        Node n6=new Node('G');
        Node n7=new Node('H');
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        return root;
    }
    //完全二叉树
    public static boolean isCompleteTree(Node root){
        Queue<Node>que=new LinkedList<>();
        if(root!=null){
            que.offer(root);
        }
        while(!que.isEmpty()){
            Node tmpNode=que.poll();
            if(tmpNode==null){
                break;
            }
            que.offer(tmpNode.left);
            que.offer(tmpNode.right);
        }
        while(que.size()>0){
            if(que.poll()!=null){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root=buildNodeTree();
        levelOrderTraversal(root);
        Node root1=buildTree();
        System.out.println(isCompleteTree(root1));
    }
}
