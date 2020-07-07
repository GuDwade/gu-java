package July;

import java.util.ArrayList;
import java.util.List;

public class Day8 {
    //路径总和 II

    List<List<Integer>>ret=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer>list=new ArrayList<>();
        dfs(root,sum,list);
        return ret;
    }

    private void dfs(TreeNode root, int sum, List<Integer> list) {
        if(root==null){
            return;
        }

        list.add(root.val);
        sum-=root.val;

        if (root.left==null&&root.right==null&&sum==0){
            ret.add(new ArrayList<>(list));
            return;
        }


        if (root.left!=null){
            dfs(root.left,sum,list);
            list.remove(list.size()-1);
        }

        if (root.right!=null){
            dfs(root.right,sum,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(5);
        TreeNode n2=new TreeNode(4);
        TreeNode n3=new TreeNode(8);
        TreeNode n4=new TreeNode(11);
        TreeNode n5=new TreeNode(13);
        TreeNode n6=new TreeNode(4);
        TreeNode n7=new TreeNode(7);
        TreeNode n8=new TreeNode(2);
        TreeNode n9=new TreeNode(5);
        TreeNode n10=new TreeNode(1);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n3.left=n5;
        n3.right=n6;
        n4.left=n7;
        n4.right=n8;
        n6.left=n9;
        n6.right=n10;


        Day8 test=new Day8();
        test.pathSum(n1,22);

    }
}
