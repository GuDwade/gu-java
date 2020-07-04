package July;

import java.util.Stack;

public class Day4 {
    //最长有效括号
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                    //保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        Day4 test=new Day4();
        test.longestValidParentheses("())(()))");
    }
}
