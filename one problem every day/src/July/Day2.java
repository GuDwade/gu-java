package July;

public class Day2 {
    //有序矩阵中第K小的元素
    //排序
    public int kthSmallest(int[][] matrix, int k) {
        int ret[]=mergeKArr(matrix);
        return ret[k-1];
    }
    public int[] mergeKArr(int[][]arr){
        int n=arr.length;
        if (n==1){
            return arr[0];
        }
        if (n==2){
            return mergeTwoArr(arr[0],arr[1]);
        }

        int mid=n/2;
        int[][]a=new int[mid][];
        for(int i=0;i<mid;i++){
            a[i]=arr[i];
        }

        int[][]b=new int[n-mid][];
        for(int i=mid;i<n;i++){
            b[i-mid]=arr[i];
        }

        return mergeTwoArr(mergeKArr(a),mergeKArr(b));

    }

    public int[] mergeTwoArr(int[]a,int[]b){
        int n=a.length;
        int m=b.length;
        int[]ret=new int[m+n];
        int j=0,i=0,idx=0;
        while (i<n&&j<m){
            if(a[i]<=b[j]){
                ret[idx++]=a[i++];
            }else{
                ret[idx++]=b[j++];
            }
        }
        while (i<n){
            ret[idx++]=a[i++];
        }
        while (j<m){
            ret[idx++]=b[j++];
        }

        return ret;
    }

    public static void main(String[] args) {
        Day2 test=new Day2();
        int[][]arr={{1,2},{1,3}};
        System.out.println(test.kthSmallest(arr, 2));
    }
}
