public class 删除链表的节点 {

        public ListNode deleteNode(ListNode head, int val) {
            if(head == null){
                return null;
            }

            if(head.val == val){
                return head.next;
            }

            ListNode cur  = head;
            ListNode prev = null;
            while(cur != null && cur.val != val){
                prev = cur;
                cur  = cur.next;
            }

            if(cur != null){
                prev.next = cur.next;
            }

            return head;

        }

}
