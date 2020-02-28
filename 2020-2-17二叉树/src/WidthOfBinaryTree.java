import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {
    public static int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int maxWid=0;
        Queue<TreeNode>que=new LinkedList<>();
        LinkedList<Integer>index=new LinkedList<>();
        que.offer(root);
        index.push(1);
        while(!que.isEmpty()){
            int count=que.size();
            //记录这一层开始时的结点坐标
            int start=index.peek();
            while(count>0) {
                TreeNode tmp = que.poll();
                count--;
                int par = index.poll();
                if (tmp.left != null) {
                    que.offer(tmp.left);
                    index.offer(2 * par);
                }
                if (tmp.right != null) {
                    que.offer(tmp.right);
                    index.offer(2 * par + 1);
                }
                //count为0 这一层结束
                //此时par就为这层最后一个结点坐标
                if(count==0){
                    //更新每层的最大深度
                   maxWid=Math.max(maxWid,par-start+1);
                }
            }
        }
        return maxWid;
    }

    public static void main(String[] args) {
        TreeNode root=BinaryTreeCon.buildTree();
        System.out.println(widthOfBinaryTree(root));
    }
}
