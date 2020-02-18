import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeCon {
    public static int i=0;
    //按照前序遍历构造树
    public static Node buildTree(String s){
        if(s.charAt(i)!='#'){
            Node root=new Node(s.charAt(i));
            i++;
            root.left=buildTree(s);
            i++;
            root.right=buildTree(s);
            return  root;
        }
        return  null;
    }

    public static void inOrder(Node root){
        if (root!=null){
            inOrder(root.left);
            System.out.print(root.value+" ");
            inOrder(root.right);
        }

    }
    //层次遍历
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ret=new ArrayList<>();
        Queue<TreeNode>que=new LinkedList<>();
        if(root!=null){
            que.offer(root);
        }else{
            return ret;
        }
        while(!que.isEmpty()){
            List<Integer>rowNode=new ArrayList<>();
            int sz=que.size();
            while(sz>0){
                TreeNode topNode=que.poll();
                rowNode.add(topNode.val);
                if (topNode.left!=null){
                    que.offer(topNode.left);
                }
                if (topNode.right!=null){
                    que.offer(topNode.right);
                }
                sz--;
            }
            ret.add(rowNode);
        }
        return  ret;
    }
    public  static TreeNode buildTree(){
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(9);
        TreeNode node3=new TreeNode(20);
        TreeNode node4=new TreeNode(11);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(17);
        TreeNode node7=new TreeNode(2);
        node1.left=node2;
        node1.right=node3;
        node2.right=node4;
        node3.left=node5;
        node3.right=node6;
        node6.left=node7;
        return node1;
    }

    public static void main(String[] args) {
        String s="cf#g#ny#h#t##hpg##h#e##oebr####h##r##";
        Node root=buildTree(s);
        inOrder(root);
        System.out.println();
        TreeNode root1=buildTree();
        List list=levelOrder(root1);
        System.out.println(list);
    }
}
