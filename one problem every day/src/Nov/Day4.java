package Nov;

public class Day4 {

    public int[][] generateMatrix(int n) {

        int [][] roads=new int[n][n];
        int startX=0;
        int endX=n-1;
        int startY=0;
        int endY=n-1;
        int idx=1;

        while (startX<=endX&&startY<=endY){
            for(int i=startY;i<=endY;i++){
                roads[startX][i]=idx++;
            }
            startX++;

            for(int i=startX;i<=endX;i++){
                roads[i][endY]=idx++;
            }
            endY--;

            for(int i=endY;i>=startY;i--){
                roads[endX][i]=idx++;
            }
            endX--;

            for(int i=endX;i>=startX;i--){
                roads[i][startY]=idx++;
            }
            startY++;
        }

        return  roads;
    }

    //矩阵置零
    public static void setZeroes(int[][] matrix) {
        boolean rowFlag = false;
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                rowFlag = true;
                break;
            }
        }

        boolean colFlag = false;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                colFlag = true;
                break;
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j =1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] ==0){
                for(int j = 1; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] ==0){
                for(int j = 1; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(rowFlag){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }

        if(colFlag){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] =0;
            }
        }

    }

    public static void main(String[] args) {
        setZeroes(new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1},
        });
    }
}
