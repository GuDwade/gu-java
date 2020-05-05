import java.util.*;

public class Test {
    //二叉搜索树的众数
    public int[] findMode(TreeNode root) {
        if (root==null){
            return  new int[]{};
        }

        Map<Integer,Integer>map=new HashMap<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;
        int max=0;

        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            map.put(cur.val,map.getOrDefault(cur.val,0)+1);
            if (map.get(cur.val)>max){
                max=map.get(cur.val);
            }
            cur=cur.right;
        }

        List<Integer>res=new ArrayList<>();
        for(Map.Entry<Integer,Integer>en:map.entrySet()){
            if (en.getValue()==max){
                res.add(en.getKey());
            }
        }

        int[]arr=new int[res.size()];
        for(int i=0;i<res.size();i++){
            arr[i]=res.get(i);
        }
        return  arr;
    }

    //验证二叉搜索树
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return  true;
        }

        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;

        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }

            cur=stack.pop();
            list.add(cur.val);
            cur=cur.right;
        }

        for (int i=0;i<list.size()-1;i++){
            if (list.get(i)>=list.get(i+1)){
                return  false;
            }
        }

        return  true;
    }

    public boolean isValidBST1(TreeNode root) {
        if (root==null){
            return  true;
        }


        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;
        long min=Long.MIN_VALUE;

        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if (min>=cur.val){
                return  false;
            }else{
                min=cur.val;
            }
            cur=cur.right;
        }

        return  true;
    }

    //二叉搜索树累加
    public TreeNode convertBST(TreeNode root) {
        if (root==null){
            return  root;
        }

        int max=0;
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;

        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){
                stack.push(cur);
                cur=cur.right;
            }
            cur=stack.pop();
            cur.val=cur.val+max;
            max=cur.val;
            cur=cur.left;
        }

        return  root;
    }
}
