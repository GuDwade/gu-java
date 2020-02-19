import java.util.Stack;

public class BinaryTreeThird {
    //树中是否含有该节点
    public boolean find(TreeNode root,TreeNode node){
        if(root==null){
            return false;
        }
        if(root==node){
            return true;
        }
        if(find(root.left,node)){
            return true;
        }
        if(find(root.right,node)){
            return true;
        }
        return false;
    }
    //最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        if(root==p||root==q){
            return root;
        }
        boolean pL,pR,qL,qR;
        pL=pR=qL=qR=false;
        if(find(root.left,p)){
            pL=true;
        }else{
            pR=true;
        }
        if(find(root.left,q)){
            qL=true;
        }else{
            qR=true;
        }
        if(qL&&pL){
            return lowestCommonAncestor(root.left,p,q);
        }else if(qR&&pR){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return  root;
        }
    }

}
