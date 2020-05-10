public class Problems {

    //搜索二维矩阵
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return  false;
        }

        int n=matrix.length;
        int m=matrix[0].length;

        int left=0;
        int right=n*m-1;

        while (left<right){
            int mid=left+right+1>>1;
            if (matrix[mid/m][mid%m]<=target){
                left=mid;
            }else{
                right=mid-1;
            }
        }

        return matrix[left/m][left%m]==target;
    }

    //寻找峰值

    public int findPeakElement(int[] nums) {
       int left=0;
       int right=nums.length-1;

       while (left<right){
           int mid=left+right>>1;
           if (nums[mid]<nums[mid+1]){
               left=mid+1;
           }else{
               right=mid;
           }
       }
       return left;
    }
}
