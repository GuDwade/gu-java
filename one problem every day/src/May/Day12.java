package May;

import java.util.Stack;

public class Day12 {
    //最小栈
    class MinStack {

        Stack<Integer>stack;
        Stack<Integer>minStack;

        public MinStack() {
            stack=new Stack<>();
            minStack=new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()||x<=minStack.peek()){
                minStack.push(x);
            }
        }

        public void pop() {
            if (stack.isEmpty()){
                return;
            }
            int tmp=stack.pop();
            if (tmp==minStack.peek()){
                minStack.pop();
            }
        }

        public int top() {
            return  stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
