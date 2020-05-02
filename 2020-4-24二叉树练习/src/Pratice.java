import java.util.Stack;

public class Pratice {
    //二叉树的坡度
    int tilt=0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }
    public int traverse(TreeNode root) {
        if(root==null ){
            return 0;
        }
        int left=traverse(root.left);
        int right=traverse(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }
    //最近公共祖先
    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q){
            return  root;
        }

        boolean pL=false,pR=false,qL=false,qR=false;
        if (find(root.left,p)){
            pL=true;
        }else{
            pR=true;
        }

        if (find(root.left,q)){
            qL=true;
        }else{
            qR=true;
        }

        if (pL&&qL){
            return lowestCommonAncestor(root.left,p,q);
        }else if(pR&&qR){
            return lowestCommonAncestor(root.right,p,q);
        }else {
            return root;
        }


    }

    private boolean find(TreeNode root, TreeNode node) {
        if (root==null){
            return  false;
        }
        if (root==node){
            return true;
        }

        if (find(root.left,node)){
            return  true;
        }

        return  find(root.right,node);
    }
    //栈记录路径
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        Stack<TreeNode> stackP=new Stack<>();
        Stack<TreeNode> stackQ=new Stack<>();

        getPath(root,p,stackP);
        getPath(root,q,stackQ);

        while (stackP.size()!=stackQ.size()){
            if (stackP.size()>stackQ.size()){
                stackP.pop();
            }else{
                stackQ.pop();
            }
        }

        while (stackP.peek()!=stackQ.peek()){
            stackP.pop();
            stackQ.pop();
        }

        return stackP.pop();
    }

    private boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> st) {
        if (root==null){
            return  false;
        }
        st.push(root);
        if (root==node){
            return true;
        }
        if (getPath(root.left,node,st)){
            return  true;
        }

        if (getPath(root.right,node,st)){
            return  true;
        }
        st.pop();
        return  false;
    }
    //二叉搜索树
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q){
            return  root;
        }

        int rootVal=root.val;
        int pVal=p.val;
        int qVal=q.val;

        if (pVal<rootVal&&qVal<rootVal){
            return  lowestCommonAncestor2(root.left,p,q);
        }else if(pVal>rootVal&&qVal>rootVal){
            return  lowestCommonAncestor2(root.right,p,q);
        }else{
            return  root;
        }
    }

}
