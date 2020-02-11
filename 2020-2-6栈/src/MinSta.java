import java.util.Stack;

public class MinSta {
    /*
    Stack <Integer>stack;
    Stack<Integer> minStack;

    public MinSta() {
        stack=new Stack();
        minStack=new Stack();
    }

    public void push(int x) {
        if(minStack.isEmpty()|| x<= minStack.peek()){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        int ret=stack.peek();
        if(ret==minStack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return  minStack.peek();
    }
    */
    int min;
    Stack <Integer>stack;
    /** initialize your data structure here. */
    public MinSta() {
        stack=new Stack();
        min=Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(stack.isEmpty()){
            min=x;
        }
        if(x<=min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop()==min){
            min=stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }
    public static void main(String[] args) {
        MinSta min=new MinSta();
        min.push(0);
        min.push(3);
        min.push(-1);
        System.out.println(min.min);
        min.pop();
        System.out.println(min.min);
    }
}

