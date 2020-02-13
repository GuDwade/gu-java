public class MyCircularQueueSize {
    int []array;
    int front;
    int rear;
    int size;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueueSize (int k) {
        array=new int[k];
        front=0;
        rear=0;
        size=0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        array[rear++]=value;
        rear=rear%array.length;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()){
            return  false;
        }
        array[front++]=0;
        front=front%array.length;
        size--;
        return true;
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
        if(rear==0){
            return array[array.length-1];
        }
        return array[rear-1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size==array.length;
    }
}
