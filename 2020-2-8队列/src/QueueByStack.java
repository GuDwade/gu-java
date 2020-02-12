import java.util.Stack;

public class QueueByStack {
    Stack<Integer>stack1;
    Stack<Integer> stack2;
    public QueueByStack() {
        stack1=new Stack();
        stack2=new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            int sz=stack1.size();
            while(sz>0){
                stack2.push(stack1.pop());
                sz--;
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            int sz=stack1.size();
            while(sz>0){
                stack2.push(stack1.pop());
                sz--;
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueByStack que=new QueueByStack();
        System.out.println(que.empty());
        que.push(1);
        que.push(2);
        que.push(3);
        que.push(4);
        System.out.println(que.peek());
        que.pop();
        System.out.println(que.peek());
    }
}
