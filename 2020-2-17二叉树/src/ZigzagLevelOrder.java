import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    //锯齿形层次遍历  奇数层从左往右输出 偶数层从右到左输出
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode>que=new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int curSize=que.size();
            List<Integer>level=new ArrayList<>();
            while(curSize>0){
                TreeNode tmp=que.poll();
                //根据list.size()来判断当前层的奇偶性
                if(list.size()%2==0){
                    level.add(tmp.val);
                }else{
                    level.add(0,tmp.val);
                }
                if(tmp.left!=null){
                    que.offer(tmp.left);
                }
                if(tmp.right!=null){
                    que.offer(tmp.right);
                }
                curSize--;
            }
            list.add(level);
        }
        return list;
    }

    public static void main(String[] args) {
    TreeNode root=BinaryTreeCon.buildTree();
    System.out.println(zigzagLevelOrder(root));
    }
}
