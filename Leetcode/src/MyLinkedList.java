class MyLinkedList {
    //设计链表

    ListNode head;
    ListNode tail;
    int size;


    public MyLinkedList() {
        size=0;
        head=null;
        tail=null;
    }


    public int get(int index) {
        if (index<0||index>=size){
            return -1;
        }
        ListNode cur=head;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return  cur.val;
    }


    public void addAtHead(int val) {
        ListNode node=new ListNode(val);
        if (head==null){
            head=node;
            tail=head;
        }else{
            node.next=head;
            head=node;
        }
        size++;
    }


    public void addAtTail(int val) {
        ListNode node=new ListNode(val);
        if (tail==null){
            tail=node;
            head=tail;
        }else{
            tail.next=node;
            tail=node;
        }
        size++;
    }


    public void addAtIndex(int index, int val) {

        if (index>size){
            return;
        }

        if(index==size){
            addAtTail(val);
            return;
        }

        if (index<=0){
            addAtHead(val);
            return;
        }

        ListNode node=new ListNode(val);
        ListNode cur=head;

        for(int i=0;i<index-1;i++){
            cur=cur.next;
        }
        node.next=cur.next;
        cur.next=node;
        size++;
    }


    public void deleteAtIndex(int index) {
        if (index<0||index>=size){
            return;
        }

        if (index==0){
            head=head.next;
            size--;
            return;
        }

        ListNode cur=head;
        for(int i=0;i<index-1;i++){
            cur=cur.next;
        }
        cur.next=cur.next.next;
        if (index==size-1){
            tail=cur;
        }
        size--;
    }

    public  MyLinkedList buildList(){
        MyLinkedList list=new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3,0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        return  list;

    }
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list=list.buildList();
        System.out.println(list.size);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
    }
}