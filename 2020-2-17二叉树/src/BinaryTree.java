class Node{
    char value;
    Node left;
    Node right;
    public Node(char value){
        this.value = value;
        left = right = null;
    }
}
public class BinaryTree {
    public static int size=0;
    public static int leafSize = 0;
    // 前序遍历
    public void preOrderTraversal(Node root){
        if(root==null){
            return ;
        }else{
            System.out.print(root.value);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
    // 中序遍历
    public  void inOrderTraversal(Node root){
        if(root==null){
            return ;
        }else{
            inOrderTraversal(root.left);
            System.out.print(root.value);
            inOrderTraversal(root.right);
        }
    }
    // 后序遍历
    public void postOrderTraversal(Node root){
        if(root==null){
            return ;
        }else{
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value);
        }
    }
    //结点个数
    public void getSize1(Node root){
        if (root!=null){
            size++;
            getSize1(root.left);
            getSize1(root.right);
        }
    }

    public int getSize2(Node root){
        if (root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return 1+getSize2(root.left)+getSize2(root.right);
    }
   //叶子结点个数
    public void getLeafSize1(Node root){
        if(root==null){
            return ;
        }
        if(root.left==null&&root.right==null){
            leafSize++;
            return ;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    public int getLeafSize2(Node root){
        if (root==null){
            return 0;
        }
        if(root.right==null&&root.left==null){
            return 1;
        }
        return  getLeafSize2(root.left)+getLeafSize2(root.right);
    }
    //k层结点个数
    public int getKSize(Node root, int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKSize(root.left,k-1)+getKSize(root.right,k-1);
    }

    public  Node buildTree(){
        Node root = new Node('A');
        Node node1 = new Node('B');
        Node node2 = new Node('C');
        Node node3 = new Node('D');
        Node node4 = new Node('E');
        Node node5 = new Node('F');
        Node node6 = new Node('G');
        Node node7 = new Node('H');
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.right = node7;
        return root;
    }
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree();
        tree.preOrderTraversal(root);
        System.out.println();
        tree.inOrderTraversal(root);
        System.out.println();
        tree.postOrderTraversal(root);
        System.out.println();
        tree.getSize1(root);
        System.out.println(tree.size);
        System.out.println(tree.getSize2(root));
        tree.getLeafSize1(root);
        System.out.println(tree.leafSize);
        System.out.println(tree.getLeafSize2(root));
        System.out.println(tree.getKSize(root,2));
    }
}
