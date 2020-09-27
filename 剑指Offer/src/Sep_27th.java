import java.util.Arrays;
import java.util.Stack;

public class Sep_27th {
    //扑克牌中的顺子
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero=0;
        int idx=0;
        while (nums[idx]==0){
            zero++;
            idx++;
        }
        int prev=nums[idx];
        for(int i=idx+1;i<nums.length;i++){
            if (nums[i]==prev+1){
                prev=nums[i];
            }else if(nums[i]==prev){
                return  false;
            }else{
                while (prev+1!=nums[i]){
                    if (zero==0){
                        return  false;
                    }
                    zero--;
                    prev++;
                }
                prev=nums[i];
            }
        }
        return  true;
    }

    //不用加减乘除做加法
    public int add(int a, int b) {
        while (b!=0){
            int fac=(a&b)<<1; //所有位计算是否要进位 ，进位到上一位，即<<1
            a=a^b;            //
            b=fac;
        }

        return  a;
    }

    //最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode>stack2=new Stack<>();

        dfs(root,p,stack1);
        dfs(root,q,stack2);

        while (stack1.size()!=stack2.size()){
            if (stack1.size()>stack2.size()){
                stack1.pop();
            }else{
                stack2.pop();
            }
        }

        while (stack1.peek()!=stack2.peek()){
            stack1.pop();
            stack2.pop();
        }
        return  stack1.peek();

    }

    public boolean dfs(TreeNode root,TreeNode find,Stack<TreeNode>stack){
        if (root==null){
            return  false;
        }

        stack.push(root);
        if (root==find){
            return  true;
        }

        if (dfs(root.left, find, stack)){
            return  true;
        }

        if (dfs(root.right, find, stack)){
            return  true;
        }

        stack.pop();
        return  false;

    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q){
            return  root;
        }

        while (root!=null){
            if(p.val<root.val&&q.val<root.val){
                root=root.left;
            }else if(p.val>root.val&&q.val>root.val){
                root=root.right;
            }else{
                break;
            }
        }

        return  root;
    }

    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{9,0,6,0,10}));
    }
}
