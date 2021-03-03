public class BSTree {

    //定义Node类
    public  static  class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    //定义根节点
    private Node root = null;

    //查找
    public Node find (int val){
        if (root == null){
            return  null;
        }

        Node cur = root;
        while (cur !=null){
            if (cur.val == val){
                return  cur;
            }else if (cur.val > val){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }

        return  null;
    }

    // 插入
    // 新的节点都是插入在叶子节点或者不完全的子树上
    public boolean insert(int val){
        if (root == null){
            root = new Node(val);
            return  true;
        }

        Node cur = root;
        Node parent = null;

        //搜索要插入的位置
        while (cur != null){
            parent = cur;
            if (cur.val == val){
                //保证插入的节点不重复
                return  false;
            }else if (cur.val > val){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }

        // 找到了合适的位置，根据与父节点的大小关系建立连接
        Node node = new Node(val);
        if (val > parent.val){
            parent.right = node;
        }else{
            parent.left = node;
        }

        return  true;
    }

    //删除
    public boolean remove(int val){
        if (root == null){
            return  false;
        }

        Node cur = root;
        Node parent = null;

        // 搜索要删除的节点
        while (cur != null){
            if (cur.val == val ){
                break;
            }else if (cur.val > val){
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }

        if (cur == null){
            return  false;
        }else{
            remove(parent,cur);
            return  true;
        }
    }

    public void remove(Node parent, Node cur){
        if (cur.left == null){
            if (cur != root){
                if (parent.left == cur){
                    parent.left = cur.right;
                }else{
                    parent.right = cur.right;
                }
            }else{
                root = cur.right;
            }
        }else if (cur.right == null){
            if (cur != root){
                if (parent.left == cur){
                    parent.left = cur.left;
                }else{
                    parent.right = cur.left;
                }
            }else{
                root = cur.left;
            }
        }else{
            // 左右都不为空选取一个新的节点作为子树的根
            // 1.左子树的最右节点 ---> 大于左子树中的所有节点，小于右子树中的所有节点
            // 2.右子树的最左节点 ---> 小于右子树中的所有节点，大于左子树中的所有节点
            // 以下为选取左子树的最右节点
            parent = cur;
            Node next = cur.left;

            while (next.right != null){
                parent = next;
                next = next.right;
            }

            cur.val = next.val;
            if (parent.left == next){
                parent.left = next.left;
            }else{
                parent.right = next.left;
            }
        }

    }

    public  void inOrder(){
        inOrderInternal(root);
        System.out.println();
    }

    private void inOrderInternal(Node root) {
        if (root != null){
            inOrderInternal(root.left);
            System.out.print(root.val + " " );
            inOrderInternal(root.right);
        }
    }


    public static void main(String[] args) {
        BSTree bs = new BSTree();
        bs.insert(10);
        bs.insert(5);
        bs.insert(6);
        bs.insert(8);
        bs.insert(3);
        bs.insert(7);
        bs.insert(2);
        bs.insert(6);
        bs.insert(11);
        bs.insert(14);
        bs.insert(12);
        bs.insert(13);
        bs.inOrder();

        bs.remove(3);
        bs.inOrder();

        bs.remove(14);
        bs.inOrder();

        bs.remove(2);
        bs.inOrder();

        bs.remove(10);
        bs.inOrder();
    }
}
