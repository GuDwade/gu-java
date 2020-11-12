package Nov;

public class Day12 {

    //按奇偶排序数组 II

    public int[] sortArrayByParityII(int[] A) {
        int l=0;
        int r=A.length-1;
        int len=A.length;

        while (l<len&&r>=0){
            while (l<len&&(A[l]+l&1)==0){
                l+=2;
            }

            while (r>=0&&(A[r]+r&1)==0){
                r-=2;
            }

            if (l<len&&r>=0){
                swap(A,l,r);
            }

        }

        return A;
    }

    private void swap(int[] a, int l, int r) {
        int tmp=a[l];
        a[l]=a[r];
        a[r]=tmp;
    }

    //旋转图像
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=tmp;
            }
        }

    }

    public static void main(String[] args) {
        int [][]nums={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(nums);
    }
}
