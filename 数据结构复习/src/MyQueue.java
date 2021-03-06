import java.util.Stack;

/**
 * 借助两个栈来实现队列
 * pushStack 只负责入队列
 * popStack  只负责出队列
 * 进行出队列操作时
 *     当popStack为空时 ：   将pushStack中的元素全部出栈加入到popStack中 根据栈后进先出原则
 *                          此时最先进入的元素存储在popStack栈顶，直接出栈即可
 *     当popStack不为空时 ： 直接出栈
 */

class MyQueue {

    Stack<Integer>  pushStack;
    Stack<Integer>  popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack  = new Stack<>();
    }


    public void push(int val) {
        pushStack.add(val);
    }


    public int pop() {
        if (popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.add(pushStack.pop());
            }
        }
        return popStack.pop();
    }


    public int peek() {
        if (popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.add(pushStack.pop());
            }
        }
        return popStack.peek();
    }


    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }
}

