import java.util.ArrayList;
import java.util.List;

public class DFSPratices {
    //字母大小全排列
    static List<String> list=new ArrayList<>();
    public static List<String> letterCasePermutation(String S) {
        char[]ret=S.toCharArray();
        dfs(ret,0);
        return list;
    }

    private static void dfs(char[] s, int i) {
        if (i==s.length){
            list.add(new String(s));
            return;
        }
        dfs(s,i+1);
        if (s[i]>='A'){
            s[i]^=32;
            dfs(s,i+1);
        }
    }
    //组合数
    static List<List<Integer>>res=new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer>path=new ArrayList<>();
        dfsCombine(path,1,n,k);
        return  res;
    }

    private static void dfsCombine(List<Integer> path, int start, int n, int k) {
        if(k==0){
            res.add(new ArrayList(path));
            return;
        }
        for(int i=start;i<=n;i++){
            path.add(i);
            dfsCombine(path,i+1,n,k-1);
            path.remove(path.size()-1);
        }
    }

    //二叉树的路径
    List<String>ans=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        String path=new String();
        dfsBinaryTree(root,path);
        return  ans;

    }

    private void dfsBinaryTree(TreeNode root, String path) {
        if (root==null){
            return;
        }
        if (path.length()>0){
            path+="->";
        }
        path+=String.valueOf(root.val);
        if (root.left==null&&root.right==null){
            list.add(path);
        }else {
            dfsBinaryTree(root.left, path);
            dfsBinaryTree(root.right, path);
        }
    }

    public static void main(String[] args) {
        List<String>list=letterCasePermutation("a1b2");
        List<List<Integer>>list1=combine(4,2);
    }
}
