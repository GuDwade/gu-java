package August;

import java.util.*;

public class Day14 {

   

    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return  true;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.abs(left-right)<2&&isBalanced(root.left)&&isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root==null){
            return  0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return left>=right?1+left:1+right;
    }

    public static int count;
    public static void main(String[]args){
        count=0;
        Scanner scan=new Scanner(System.in);
        while(scan.hasNextInt()){
            double R=scan.nextInt();
            int[]n1=new int[]{scan.nextInt(),scan.nextInt()};
            int[]n2={scan.nextInt(),scan.nextInt()};
            int[]n3={scan.nextInt(),scan.nextInt()};
            int[]s={scan.nextInt(),scan.nextInt()};
            add(n1,s,R);
            add(n2,s,R);
            add(n3,s,R);
            System.out.println(count+"x");
        }
    }

    public static void  add(int[]n,int[]s,double R){
        double l=Math.sqrt(Math.pow(n[0]-s[0],2)+Math.pow(n[1]-s[1],2));
        if (l<=R){
            count++;
        }
    }
}
