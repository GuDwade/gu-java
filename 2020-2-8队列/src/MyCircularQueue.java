public class MyCircularQueue {
    int []array;
    int front;
    //rear: 队尾元素的下一个位置
    int rear;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        array=new int[k+1];
        front=0;
        rear=0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        array[rear++]=value;
        rear=rear%array.length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()){
            return  false;
        }
        array[front++]=0;
        front=front%array.length;
        return  true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return array[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        //队尾元素在 rear-1的位置
        if(rear==0){
            return array[array.length-1];
        }
        return array[rear-1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front==rear;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear+1)%array.length==front;
    }

    public static void main(String[] args) {
        MyCircularQueue que=new MyCircularQueue(5);
        que.enQueue(1);
        que.enQueue(2);
        que.enQueue(3);
        que.enQueue(4);
        que.enQueue(5);
        System.out.println(que.enQueue(6));
        que.deQueue();
        System.out.println(que.enQueue(6));
        System.out.println(que.isFull());
    }
}
