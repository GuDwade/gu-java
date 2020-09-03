public class 二叉搜索树与双向链表 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };


    Node prev,head;
    public Node treeToDoublyList(Node root) {
        if (root==null){
            return  null;
        }
        dfs(root);
        prev.right=head;
        head.left=prev;
        return  head;
    }

    private void dfs(Node cur) {
        if (cur==null){
            return;
        }
        dfs(cur.left);
        if (prev==null){
            head=cur;
        }else{
            prev.right=cur;
        }
        cur.left=prev;
        prev=cur;
        dfs(cur.right);
    }

    public   Node buildTree(){
        Node n4=new Node(4);
        Node n2=new Node(2);
        Node n5=new Node(5);
        Node n1=new Node(1);
        Node n3=new Node(3);

        n4.left=n2;
        n4.right=n5;

        n2.left=n1;
        n2.right=n3;

        return  n4;
    }

    public static void main(String[] args) {
        二叉搜索树与双向链表 test=new 二叉搜索树与双向链表();
        test.treeToDoublyList(test.buildTree());
    }
}
