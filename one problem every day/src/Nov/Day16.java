package Nov;


import java.util.Stack;

public class Day16 {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k){
            return  "0";
        }

        Stack<Integer>stack =new Stack<>();
        stack.push(num.charAt(0)-'0');

        for(int i=1;i<num.length();i++){
            int cur=num.charAt(i)-'0';
            while (!stack.isEmpty()&&k>0&&stack.peek()>cur){
                stack.pop();
                k--;
            }

            if(cur!=0||!stack.isEmpty()){
                stack.push(cur);
            }
        }

        while (k>0&&!stack.isEmpty()){
            stack.pop();
            k--;
        }

        if (stack.isEmpty()){
            return  "0";
        }
        StringBuilder sb =new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return  sb.reverse().toString();

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}