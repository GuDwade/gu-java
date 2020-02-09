import java.util.LinkedList;
import java.util.Queue;

public class StackByQueue {
    Queue<Integer>queue;
    /** Initialize your data structure here. */
    public StackByQueue() {
        queue=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int sz=queue.size();
        while(sz>1){
            queue.offer(queue.poll());
            sz--;
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        int sz=queue.size();
        while(sz>1){
            queue.offer(queue.poll());
            sz--;
        }
        int ret=queue.poll();
        queue.offer(ret);
        return  ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return  queue.isEmpty();

    }

    public static void main(String[] args) {
        StackByQueue stack=new StackByQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
