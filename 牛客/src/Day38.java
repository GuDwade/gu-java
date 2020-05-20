import java.util.Scanner;

public class Day38 {
    //二维数组打印
    public static int[] arrayPrint(int[][] arr, int n) {
        int[]ret=new int[n*n];
        int idx=0;
        for(int t=n-1;t>=0;t--){
            int i=0;
            int j=t;
            while (i<n&&j<n){
                ret[idx++]=arr[i++][j++];
            }
        }

        for(int t=1;t<n;t++){
            int j=0;
            int i=t;
            while (i<n&&j<n){
                ret[idx++]=arr[i++][j++];
            }
        }

        return  ret;
    }



    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String str=scan.nextLine();
            if(isHuiWen(str)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    //回文串  删除一个和添加一个一样
    private static boolean isHuiWen(String str) {
        int left=0;
        int right=str.length()-1;
        while (left<right){
            if (str.charAt(left)==str.charAt(right)){
                left++;
                right--;
            }else{
                boolean flagLeft=true;
                boolean flagRight=true;
                //在左边添加一个和right相同的字符  right被匹配  {left,right-1}是否构成回文串
                for(int i=left,j=right-1;i<j;i++,j--){
                    if (str.charAt(i)!=str.charAt(j)){
                        flagLeft=false;
                        break;
                    }
                }
                //在右边添加一个和left相同的字符  left被匹配  {left+1,right}是否构成回文串
                for(int i=left+1,j=right;i<j;i++,j--){
                    if (str.charAt(i)!=str.charAt(j)){
                        flagRight=false;
                        break;
                    }
                }

                return flagLeft||flagRight;
            }

        }
        return  true;
    }
}
