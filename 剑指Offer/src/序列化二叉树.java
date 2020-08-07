import java.util.LinkedList;
import java.util.Queue;

public class 序列化二叉树 {
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder("[");
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if (cur!=null){
                sb.append(cur.val+",");
                queue.add(cur.left);
                queue.add(cur.right);
            }else {
                sb.append("null"+",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]datas=data.substring(1,data.length()-1).split(",");
        TreeNode root=getNode(datas[0]);
        Queue<TreeNode>parents=new LinkedList<>();
        TreeNode parent=root;
        boolean isLeft=true;

        for(int i=1;i<datas.length;i++){
            TreeNode cur=getNode(datas[i]);
            if (isLeft){
                parent.left=cur;
            }else{
                parent.right=cur;
            }
            isLeft=!isLeft;
            if (cur!=null){
                parents.add(cur);
            }
            if (isLeft){
                parent=parents.poll();
            }
        }
        return  root;
    }

    private TreeNode getNode(String data) {
        if (data.equals("null")){
            return  null;
        }
        return  new TreeNode(Integer.parseInt(data));
    }
}
