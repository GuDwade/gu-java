import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue ;

    public MyStack() {
        queue = new LinkedList();
    }


    public void push(int x) {
        queue.offer(x);
        for(int i = queue.size() - 1; i > 0; i--){
            queue.offer(queue.poll());
        }
    }


    public int pop() {
        return  queue.poll();
    }


    public int top() {
        return  queue.peek();
    }


    public boolean empty() {
        return  queue.isEmpty() ;
    }
}