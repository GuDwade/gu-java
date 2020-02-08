class Node {
    int val;
    Node next;
    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
    Node(int val) {
        this(val, null);
    }
}
public class MyQueue {
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    //入队
    public void offer(int val) {
        Node node =new Node(val);
        if(tail==null){
            head=node;
        }else{
            tail.next=node;
        }
        tail=node;
        size++;
    }
    //出队
    public void poll() {
        if (size == 0) {
            throw new RuntimeException("队列为空");
        }
        head=head.next;
        if (head==null){
            tail=null;
        }
        size--;
    }
    //队头元素
    public int peek() {
        if (size == 0) {
            throw new RuntimeException("队列为空");
        }
        return head.val;
    }
    public  boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyQueue que=new MyQueue();
        System.out.println(que.size);
        System.out.println(que.isEmpty());
        que.offer(1);
        que.offer(2);
        que.offer(3);
        que.offer(4);
        System.out.println(que.size);
        System.out.println(que.peek());
        que.poll();
        System.out.println(que.peek());
        System.out.println(que.size);

    }
}
