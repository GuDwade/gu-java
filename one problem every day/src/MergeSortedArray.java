import java.util.Arrays;

public class MergeSortedArray {
    //从头开始
    public static void merge(int[] A, int m, int[] B, int n) {
        int[]copy=Arrays.copyOf(A,m);
        int i=0;
        int j=0;
        int index=0;
        while(i<m&&j<n){
            if(copy[i]<=B[j]){
                A[index++]=copy[i++];
            }else{
                A[index++]=copy[j++];
            }
        }
        while (i<m)
            A[index++]=copy[i++];
        while (j<n)
            A[index++]=B[j++];
    }
    //从尾开始
    public static void merge1(int[] A, int m, int[] B, int n) {
        int i=m-1;
        int j=n-1;
        int index=m+n-1;
        while(i>=0&&j>=0){
            if(A[i]>B[j]){
                A[index--]=A[i--];
            }else{
                A[index--]=B[j--];
            }
        }
        while (j>=0)
            A[index--]=B[j--];
    }

    public static void main(String[] args) {
        int[]arr1={2,5,5,7,9,0,0,0};
        int[]arr2={2,5,6};
        //merge(arr1,5,arr2,3);
        merge1(arr1,5,arr2,3);
        System.out.println(Arrays.toString(arr1));
    }
}
