package August;

public class Day15 {
    //有序链表转换二叉搜索树
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null){
            return  null;
        }

        if (head.next==null){
            return new TreeNode(head.val);
        }

        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root=new TreeNode(slow.val);
        ListNode past=slow.next;
        prev.next=null;
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(past);
        return  root;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}