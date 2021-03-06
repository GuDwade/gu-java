public class Queue {

    public static  class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }


    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        front = rear = null;
        this.size = 0;
    }


    public void offer(int val) {
        Node node = new Node(val);
        if (front == null){
            front = rear = node;
        }else{
            rear.next = node;
            rear = rear.next;
        }
        size++;
    }

    public  void  poll(){
        if (front == null){
            return;
        }

        front = front.next;
        //队列中只有一个节点，更新尾节点
        if (front == null){
            rear = null;
        }
        size--;
    }

    public int peek(){
        if (size == 0){
            throw new RuntimeException("队列为空");
        }

        return  front.val;
    }


    public int getSize(){
        return  size;
    }

    public boolean isEmpty(){
        return  size == 0;
    }
}
