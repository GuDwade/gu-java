import java.util.Arrays;

public class Day49 {

    //左右最值最大差
    public int findMaxGap(int[] A, int n) {
       int[]leftMax=new int[n];
       leftMax[0]=A[0];
       for(int i=1;i<n;i++){
           leftMax[i]=Math.max(A[i],leftMax[i-1]);
       }
       int rightMax[]=new int[n];
       rightMax[n-1]=A[n-1];
       for(int i=n-2;i>=0;i--){
           rightMax[i]=Math.max(A[i],rightMax[i+1]);
       }
       int max=-1;
       for(int i=0;i<n;i++){
           max=Math.max(max,Math.abs(rightMax[i]-leftMax[i]));
       }
       return  max;
    }

    //顺时针打印矩阵
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        int[] ret=new int[n*m];
        int startX=0;
        int startY=0;
        int endX=n-1;
        int endY=m-1;
        int idx=0;

        while (startX<=endX&&startY<=endY){
            //从左到右
            if(startX<=endX){
                for(int i=startY;i<=endY;i++){
                    ret[idx++]=mat[startX][i];
                }
            }

            //从上到下
            if(startY<=endY){
                for(int i=startX+1;i<=endX;i++){
                    ret[idx++]=mat[i][endY];
                }
            }

            //从右到左
            if(endX>startX&&endY>startY){
                for(int i=endY-1;i>=startY;i--){
                    ret[idx++]=mat[endX][i];
                }
            }

            //从上到下
            if(endX>startX&&endY>startY){
                for(int i=endX-1;i>startX;i--){
                    ret[idx++]=mat[i][startY];
                }
            }

            startX++;
            startY++;
            endX--;
            endY--;
        }

        return  ret;
    }


    public static void main(String[] args) {
        Day49 test=new Day49();
        int[][]arr={{1,2,3},{8,9,4},{7,6,5}};
        System.out.println(Arrays.toString(test.clockwisePrint(arr, 3, 3)));

    }
}
