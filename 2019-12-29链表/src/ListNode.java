public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public  static  void print(ListNode head){
        if(head==null){
            return;
        }
        ListNode cur=head;
        while(cur!=null){
            System.out.printf("%s\t",cur.val);
            cur=cur.next;
        }
        System.out.println();
    }
}
