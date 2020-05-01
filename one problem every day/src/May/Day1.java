package May;

public class Day1 {
    //合并有序链表   注意合并K个排序链表 分治
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if (l2==null){
            return  l1;
        }

        ListNode nHead=null;
        ListNode nTail=nHead;

        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                if (nHead==null){
                    nHead=l1;
                }else{
                    nTail.next=l1;
                }
                nTail=l1;
                l1=l1.next;
            }else{
                if (nHead==null){
                    nHead=l2;
                }else{
                    nTail.next=l2;
                }
                nTail=l2;
                l2=l2.next;
            }
        }

        if (l1==null){
            nTail.next=l2;
        }
        if (l2==null){
            nTail.next=l1;
        }
        return  nHead;

    }
}
