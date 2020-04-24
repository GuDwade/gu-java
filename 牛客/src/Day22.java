import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day22 {
    //平衡二叉树
    public int maxDepth(TreeNode root) {
        if(root==null){
            return  0;
        }
        if (root.left==null&&root.right==null){
            return  1;
        }

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return  true;
        }

        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        if (Math.abs(left-right)>1){
            return  false;
        }
        return  isBalanced(root.left)&&isBalanced(root.right);

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=scanner.nextInt();
        }
        int A1=0,A2=0,A3=0,A5=0;
        double A4=0;
        A1=A1(arr);
        A2=A2(arr);
        A3=A3(arr);
        A4=A4(arr);
        A5=A5(arr);

        if(A1!=0){
            System.out.print(A1+" ");
        } else{
            System.out.print('N'+" ");
        }

        if(A2!=0){
            System.out.print(A2+" ");
        }else{
            System.out.print('N'+" ");
        }

        if(A3!=0){
            System.out.print(A3+" ");
        }else{
            System.out.print('N'+" ");
        }

        if(A4!=0) {
            System.out.printf("%.1f\t",A4);
        }else{
            System.out.print("N"+" ");
        }
        if(A5!=0){
            System.out.print(A5);
        } else{
            System.out.print("N");
        }

}


    private static int A5(int[]arr) {
        int max=-1;
        for (int i:arr){
            if (i%5==4&i>max){
               max=i;
            }
        }
        return max;
    }

    private static double A4(int[]arr) {
        double  sum=0;
        int count=0;
        for (int i:arr){
            if (i%5==3){
                sum+=i;
                count++;
            }
        }
        return  sum/count;

    }

    private static int A3(int[]arr) {
        int count=0;
        for (int i:arr){
            if (i%5==2){
                count++;
            }
        }
        return  count;
    }

    private static int A2(int[]arr) {
        List<Integer>list1=new ArrayList<>();
        for (int i:arr){
            if (i%5==1){
                list1.add(i);
            }
        }
        int sum=0;
        int sign=-1;
        for (int i=0;i<list1.size();i++){
            sign*=-1;
            sum+=sign*list1.get(i);
        }
        return sum;
    }

    private   static  int A1(int[]arr){
        int sum=0;
        for (int i:arr){
            if (i%5==0&&i%2==0){
                sum+=i;
            }
        }
        return sum;
    }
}
