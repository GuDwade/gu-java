import java.util.*;

public class 从上到下打印二叉树 {

    public int[] levelOrder(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();

        if (root!=null){
            queue.offer(root);
        }

        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            list.add(cur.val);
            if (cur.left!=null){
                queue.offer(cur.left);
            }
            if (cur.right!=null){
                queue.offer(cur.right);
            }
        }
        int []ret=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }
        return  ret;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>>ret=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();

        if(root!=null){
            queue.offer(root);
        }

        while (!queue.isEmpty()){
            int sz=queue.size();
            List<Integer>list=new ArrayList<>();
            while (sz>0){
                TreeNode  cur=queue.poll();
                list.add(cur.val);

                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
                sz--;
            }
            ret.add(new ArrayList<>(list));
        }

        return  ret;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>>ret=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();

        if(root!=null){
            queue.offer(root);
        }

        while (!queue.isEmpty()){
            int sz=queue.size();
            List<Integer>list=new ArrayList<>();
            while (sz>0){
                TreeNode  cur=queue.poll();
                list.add(cur.val);

                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
                sz--;
            }
            int level=ret.size();
            if (level%2==1){
                Collections.reverse(list);
            }
            ret.add(new ArrayList<>(list));
        }

        return  ret;
    }
}
