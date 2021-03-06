import java.util.Stack;

public class MinStack {
    Stack<Integer>stack;
    Stack<Integer>minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek() ){
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        int pop = stack.pop();
        if (pop == stack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return  stack.pop();
    }

    public int getMin() {
        return  minStack.peek();
    }
}
