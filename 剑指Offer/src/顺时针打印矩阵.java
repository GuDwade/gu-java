public class 顺时针打印矩阵 {

    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return new int[]{};
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int []ret=new int[m*n];
        int startX=0;
        int startY=0;
        int endX=m-1;
        int endY=n-1;
        int idx=0;

        while(startX<=endX&&startY<=endY){
            if(startX<=endX){
                for(int i=startY;i<=endY;i++){
                    ret[idx++]=matrix[startX][i];
                }
            }

            if(startY<=endY){
                for(int i=startX+1;i<=endX;i++){
                    ret[idx++]=matrix[i][endY];
                }
            }

            if(startX<endX&&startY<endY){
                for(int i=endY-1;i>=startY;i--){
                    ret[idx++]=matrix[endX][i];
                }
            }

            if(startX<endX&&startY<endY){
                for(int i=endX-1;i>startX;i--){
                    ret[idx++]=matrix[i][startY];
                }
            }

            startX++;
            startY++;
            endX--;
            endY--;

        }
        return ret;
    }
}
