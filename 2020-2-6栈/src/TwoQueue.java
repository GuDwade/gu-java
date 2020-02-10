import java.util.LinkedList;
import java.util.Queue;

public class TwoQueue {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public TwoQueue(){
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.isEmpty()){
            queue2.offer(x);
        }else{
            queue1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int ret=0;
        if(queue1.isEmpty()){
            int sz=queue2.size();
            while(sz>1){
                queue1.offer(queue2.poll());
                sz--;
            }
            ret=queue2.poll();
        } else{
            int sz=queue1.size();
            while(sz>1){
                queue2.offer(queue1.poll());
                sz--;
            }
            ret=queue1.poll();
        }
        return ret;
    }

    /** Get the top element. */
    public int top() {
        int ret=pop();
        push(ret);
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return  queue1.isEmpty()&&queue2.isEmpty();
    }

    public int size(){
        return  queue1.size()+queue2.size();
    }
    public static void main(String[] args) {
        TwoQueue stack=new TwoQueue();
        System.out.println(stack.size());
        System.out.println(stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.size());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.pop());
    }
}
