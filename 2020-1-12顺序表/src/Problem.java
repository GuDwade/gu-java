public class Problem {
    public static Node middleNode(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static Node middleNode1(Node head) {
        int size=0;
        Node cur=head;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        Node tmp=head;
        for(int i=0;i<size/2;i++) {
            tmp=tmp.next;
        }
        return tmp;
    }

    public static Node FindKthToTail(Node head,int k) {
        if(head==null){
            return null;
        }
        int size=0;
        Node cur=head;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        if(size<k){
            return  null;
        }
        Node tmp=head;
        for(int i=0;i<size-k;i++) {
            tmp=tmp.next;
        }
        return tmp;
    }

    public static void main(String[] args) {
        Node n1=Practices.bulidList();
        MyLinkList.print(middleNode(n1));
        System.out.println();
        MyLinkList.print(middleNode1(n1));
        System.out.println();
        MyLinkList.print(FindKthToTail(n1,5));
    }
}
