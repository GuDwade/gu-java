import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 打印二叉树 {

    public int[] levelOrder(TreeNode root) {

        if (root == null){
            return  new int[]{};
        }


        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int sz = queue.size();
            while (sz > 0){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                sz--;

                if (cur.left != null){
                    queue.offer(cur.left);
                }

                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }

        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size(); i++ ){
            ret[i] = list.get(i);
        }

        return  ret;
    }


    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null){
            return  new ArrayList<>();
        }


        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int sz = queue.size();
            List<Integer> road = new ArrayList<>();

            while (sz > 0){
                TreeNode cur = queue.poll();
                road.add(cur.val);
                sz--;

                if (cur.left != null){
                    queue.offer(cur.left);
                }

                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            list.add(new ArrayList<>(road));
        }


        return  list;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null){
            return  new ArrayList<>();
        }


        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()){
            int sz = queue.size();
            List<Integer> road = new ArrayList<>();

            while (sz > 0){
                TreeNode cur = queue.poll();
                if ((level & 1 )== 0){
                    road.add(cur.val);
                }else{
                    road.add(0,cur.val);
                }

                sz--;

                if (cur.left != null){
                    queue.offer(cur.left);
                }

                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            list.add(new ArrayList<>(road));
            level++;
        }


        return  list;
    }
}
