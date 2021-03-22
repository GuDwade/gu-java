import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 顺时针打印矩阵 {

    public static int[] spiralOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return  new int[]{};
        }

        int n = matrix.length;
        int[]ret = new int[n * n];

        int l = 0 , r = n - 1, u = 0, d = n - 1, idx = 0;
        while (l <= r && u <= d){

            if (l <= r){
                for(int i = l; i <= r; i++ ){
                    ret[idx++] = matrix[u][i];
                }
            }
            u++;


            if (u <= d){
                for(int i = u; i <= d; i++ ){
                    ret[idx++] = matrix[i][r];
                }
            }
            r--;

            if (r >= l){
                for(int i = r; i >= l; i-- ){
                    ret[idx++] = matrix[d][i];
                }
            }
            d--;

            if (u <= d){
                for(int i = d; i >= u; i-- ){
                    ret[idx++] = matrix[i][l];
                }
            }
            l++;
        }

        return  ret;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return  new ArrayList<Integer>();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> ret = new ArrayList<>();

        int l = 0, r = n - 1, u = 0, d = m - 1;

        while (l <= r && u <= d){

            for(int i = l; i <= r; i++ ){
                ret.add(matrix[u][i]) ;
            }

            if (++u > d){
                break;
            }

            for(int i = u; i <= d; i++ ){
                ret.add(matrix[i][r]);
            }
            if (--r < l){
                break;
            }


            for(int i = r; i >= l; i-- ){
                ret.add(matrix[d][i]);
            }
            if (--d < u){
                break;
            }

            for(int i = d; i >= u; i-- ){
                ret.add(matrix[i][l]);
            }
            if (++l > r){
                break;
            }

        }

        return  ret;

    }

    public static void main(String[] args) {
        int[][] martix ={
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };
        spiralOrder(martix);
    }
}
