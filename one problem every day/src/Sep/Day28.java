package Sep;

import java.util.LinkedList;
import java.util.Queue;

public class Day28 {
    //填充每个节点的下一个右侧节点指针 II
    public Node connect(Node root) {
        if(root==null){
            return root;
        }

        Node cur=root;
        Queue<Node> queue=new LinkedList<>();
        queue.add(cur);

        while(!queue.isEmpty()){
            int sz=queue.size();
            while (sz>0){
                 cur=queue.poll();
                 sz--;
                 if (sz>0){
                     cur.next=queue.peek();
                 }
                 if (cur.left!=null){
                     queue.add(cur.left);
                 }
                 if (cur.right!=null){
                     queue.add(cur.right);
                 }
            }
        }

        return  root;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}