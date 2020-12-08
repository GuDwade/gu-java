package December;

public class Day7 {

    //翻转矩阵后的得分
    public int matrixScore(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        for(int i = 0; i < n ; i++) {
            if (A[i][0] == 0){
                for(int j = 0; j < m; j++) {
                    A[i][j] ^= 1;
                }
            }
        }

        for(int i = 1; i < m; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if (A[j][i] == 1){
                    cnt++;
                }
            }

            if (cnt < (n + 1) / 2) {
                for(int j = 0; j < n; j++){
                   A[j][i] ^= 1;
                }
            }
        }

        int ret = 0;
        for(int i = 0; i < n; i++) {
            int sum =0;
            for(int j = 0; j < m; j++){
                sum <<= 1;
                sum += A[i][j];
            }
            ret += sum;
        }

        return  ret;
    }
}
