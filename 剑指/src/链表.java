public class 链表 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null){
            return  head;
        }

        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0; i < k; i++ ){
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return  slow;

    }


    public ListNode reverseList(ListNode head) {
        if (head == null  || head.next == null){
            return  head;
        }

        ListNode prev = null;
        ListNode cur  = head;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return  prev;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return  l2;
        }

        if (l2 == null){
            return  l1;
        }

        ListNode nHead = null;
        ListNode nTail = nHead;


        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                if (nHead == null){
                    nHead = l1;
                    nTail = l1;
                }else{
                    nTail.next = l1;
                    nTail = nTail.next;
                }
                l1 = l1.next;
            }else{
                if (nHead == null){
                    nHead = l2;
                    nTail = l2;
                }else{
                    nTail.next = l2;
                    nTail = nTail.next;
                }
                l2 = l2.next;
            }
        }

        if (l1 != null){
            nTail.next = l1;
        }

        if (l2 != null){
            nTail.next = l2;
        }

        return  nHead;
    }
}
