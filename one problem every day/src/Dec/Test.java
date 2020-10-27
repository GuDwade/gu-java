package Dec;

import java.util.Arrays;

public class Test {
    //插入排序
    //最好 O(n) 升序  最坏 O(n*n) 逆序 平均 O(n*n)
    public static void insertSort(int[] array) {
        for(int i=1;i<=array.length-1;i++){
            int end=i-1;
            int val=array[i];
            while (end>=0&&val<array[end]){
                array[end+1]=array[end];
                end--;
            }
            array[end+1]=val;
        }
    }

    //希尔排序
    //平均 O(n*1.3) 不稳定
    public static void shellSort(int[] array) {
        int gap=array.length;

        while (gap>1){
            gap/=2;
            for(int i=0;i<array.length-gap;i++){
                int end=i;
                int val=array[i+gap];
                while (end>=0&&val<array[end]){
                    array[end+gap]=array[end];
                    end-=gap;
                }
                array[end+gap]=val;
            }
        }
    }

    //选择排序
    public static void selectSort(int[] array) {
        for(int i=array.length-1;i>0;i--){
            int end=i;
            int max=i;
            for(int j=i-1;j>=0;j--){
                if (array[j]>array[max]){
                    max=j;
                }
            }
            int tmp=array[end];
            array[end]=array[max];
            array[max]=tmp;
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] array) {
        for(int i=0;i<array.length-1;i++){
            boolean flag=true;
            for(int j=0;j<array.length-i-1;j++){
                if (array[j]>array[j+1]){
                    flag=false;
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
            if (flag){
                break;
            }
        }
    }
    
    //快速排序
    
    public static void quickSort(int[] arr, int left, int right){
        if (left<right){
            int mid=partion(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }

    private static int partion(int[] arr, int left, int right) {
        int val=arr[left];
        int start=left;
        while (left<right){
            while (left<right&arr[right]>=val){
                right--;
            }

            while (left<right&&arr[left]<val){
                left++;
            }

            swap(arr,left,right);
        }

        swap(arr,start,left);
        return left;
    }

    //归并排序
    public static void merge(int[]arr){
        int[]tmp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,tmp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] tmp) {
        if (left<right){
            int mid=(left+right)>>1;
            mergeSort(arr,left,mid,tmp);
            mergeSort(arr,mid+1,right,tmp);
            mergeTwoArray(arr,left,right,mid,tmp);
        }
    }

    private static void mergeTwoArray(int[] arr, int left, int right, int mid,int[]helper) {
        int start1=left,end1=mid;
        int start2=mid+1,end2=right;
        int idx=left;

        while (start1<=end1&&start2<=end2){
            if (arr[start1]<=arr[start2]){
                helper[idx++]=arr[start1++];
            }else{
                helper[idx++]=arr[start2++];
            }
        }

        while (start1<=end1){
            helper[idx++]=arr[start1++];
        }

        while (start2<=end2){
            helper[idx++]=arr[start2++];
        }

        for(int i=left;i<=right;i++){
            arr[i]=helper[i];
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp=arr[left];
        arr[left]=arr[right];
        arr[right]=tmp;
    }

    public static  String toLowAndUp(String str){
        char[]chars=str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i]=(char)(chars[i]+32);
            }else{
                chars[i]=(char)(chars[i]-32);
            }
        }
        return  new String(chars);
    }
    public static void main(String[] args) {
        int []arr=new int[]{12,4,7,12,34,23,17,45};
        //insertSort(arr);
        //shellSort(arr);
        //selectSort(arr);
        //bubbleSort(arr);
        //quickSort(arr,0,arr.length-1);
        merge(arr);
        String str="SJHAggdsHCAfdjksa";
        System.out.println(str);
        System.out.println(toLowAndUp(str));
        System.out.println(Arrays.toString(arr));
    }
}
