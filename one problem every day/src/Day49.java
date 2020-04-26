public class Day49 {
    //合并k个排序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0||lists==null){
            return  null;
        }
        if (lists.length==1){
            return  lists[0];
        }
        if (lists.length==2){
            return mergeTwoLists(lists[0],lists[1]);
        }

        int mid=lists.length/2;
        ListNode[] first=new ListNode[mid];
        for (int i=0;i<mid;i++){
            first[i]=lists[i];
        }

        ListNode[] second=new ListNode[lists.length-mid];
        for(int j=mid;j<lists.length;j++){
            second[j-mid]=lists[j];
        }

        return mergeTwoLists(mergeKLists(first),mergeKLists(second));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        ListNode head=null;
        ListNode tail=head;

        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                if (head==null){
                    head=l1;
                }else{
                    tail.next=l1;
                }
                tail=l1;
                l1=l1.next;
            }else{
                if (head==null){
                    head=l2;
                }else{
                    tail.next=l2;
                }
                tail=l2;
                l2=l2.next;
            }
        }
        if (l1==null){
            tail.next=l2;
        }
        if (l2==null){
            tail.next=l1;
        }
        return head;
    }
}
