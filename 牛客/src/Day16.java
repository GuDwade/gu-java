class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Day16 {

    public ListNode deleteDuplication(ListNode pHead){
        if (pHead==null||pHead.next==null){
            return pHead;
        }

        ListNode fake=new ListNode(-1);
        ListNode prev=fake;
        prev.next=pHead;
        ListNode cur=pHead;
        ListNode next=pHead.next;

        while(next!=null){
            if(cur.val!=next.val){
                prev=prev.next;
                cur=cur.next;
                next=next.next;
            }else{
                while (next!=null&&next.val==cur.val){
                    next=next.next;
                }
                prev.next=next;
                cur=next;
                if(next!=null){
                    next=next.next;
                }
            }
        }
        return  fake.next;
    }
    //二叉树的镜像
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }


}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
