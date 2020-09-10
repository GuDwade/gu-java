public class 二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return  dfs(postorder,0,postorder.length-1);
    }

    private boolean dfs(int[] postorder, int l, int r) {
        if(l>=r){
            return  true;
        }

        int root=postorder[r];
        int s=l;
        while (s<r&&postorder[s]<root){
            s++;
        }
        for(int i=s;i<r;i++){
            if (postorder[i]<root){
                return  false;
            }
        }

        return  dfs(postorder,l,s-1)&&dfs(postorder,s,r-1);
    }
}
