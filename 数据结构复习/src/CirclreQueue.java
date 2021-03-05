
class MyCircularQueue{
    private int[] array;
    //front: 队头元素的位置
    private int front;
    //rear: 队尾元素的下一个位置
    private int rear;
    //size : 队列元素个数
    private int size;

    public MyCircularQueue(int k) {
        array = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        //判断队列是否已满
        if (isFull()){
            return  false;
        }
        //尾插
        array[rear++] = value;
        //更新位置
        rear = rear % array.length;
        //更新元素个数
        size++;
        return  true;
    }

    public boolean deQueue() {
        //判断队列是否为空
        if (isEmpty()){
            return false;
        }
        ////头删，向后移动队头的位置
        front++;
        front = front % array.length;
        size--;
        return  true;
    }

    public int Front() {
        if (isEmpty()){
            return  -1;
        }
        return  array[front];
    }


    public int Rear() {
        if (isEmpty()){
            return  -1;
        }
        // rear在 0 位置 ，且不为空 ,队尾下标为 array.length - 1
        if (rear == 0){
            return  array[array.length - 1];
        }
        //队尾元素在 rear-1的位置
        return  array[rear - 1];
    }

    public boolean isEmpty() {
        return  size == 0;
    }

    public boolean isFull() {
        return  size == array.length;
    }
}