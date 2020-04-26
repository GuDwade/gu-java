import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Order {
    //层序遍历
    public static void leverOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return ;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode topNode = queue.poll();
            System.out.print(topNode.val+" ");
            if(topNode.left != null){
                queue.offer(topNode.left);
            }
            if(topNode.right != null){
                queue.offer(topNode.right);
            }
        }
    }

    // 递归前序遍历
    public static void prOrder(TreeNode root){
        if(root != null){
            System.out.print(root.val + " ");
            prOrder(root.left);
            prOrder(root.right);
        }
    }
    //非递归前序遍历
    public static void prOrderNoR(TreeNode root){
        Stack<TreeNode>  st = new Stack<>();
        TreeNode curNode = root;

        while(curNode != null || !st.isEmpty()){
            while(curNode != null){
                //首先访问根
                System.out.print(curNode.val + " ");
                //访问根的左子树
                st.push(curNode);
                curNode = curNode.left;
            }
            //获取栈顶(根)元素
            curNode = st.pop();
            //访问栈顶(根)元素的右子树
            curNode = curNode.right;
        }

        System.out.println();
    }
    // 递归中序遍历
    public static void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    //非递归中序遍历
    public static void inOrderNoR(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        TreeNode curNode = root;

        while(curNode != null || ! st.isEmpty()){
            while(curNode != null){
                //访问左子树
                st.push(curNode);
                curNode = curNode.left;
            }
            //访问根
            curNode = st.pop();
            System.out.print(curNode.val + " ");
            //访问右子树
            curNode = curNode.right;
        }
        System.out.println();
    }

    // 递归后序遍历
    public static void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }
    //非递归后序遍历
    public static void postOrderNoR(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        TreeNode curNode = root;
        TreeNode prev = null;

        while(curNode != null || ! st.isEmpty()){
            while(curNode != null){
                //左子树
                st.push(curNode);
                curNode = curNode.left;
            }
            //根: 访问完右子树之后，才能访问根
            curNode = st.peek();
            //判断右子树是由已经访问完：
            // 1. curNode.right == null : 没有右子树
            // 2. curNode.right == prev:  有右子树，并且右子树的根上一次已经访问结束，即右子树访问完成
            if(curNode.right == null || curNode.right == prev){
                System.out.print(curNode.val + " ");
                prev = curNode;
                st.pop();
                curNode = null;
            }
            else{
                //右子树
                curNode = curNode.right;
            }
        }
        System.out.println();
    }
}
