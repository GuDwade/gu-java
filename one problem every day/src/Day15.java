public class Day15 {
    //最小的K个数
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int []ret=new int[k];
        int i=0;
        for(;i<k;i++){
            ret[i]=arr[i];
        }
        //建大堆
        for(int j=(k-2)/2;j>=0;j--){
            shiftDownMax(ret,k,j);
        }
        while(i<arr.length){
            if(arr[i]<ret[0]){
                ret[0]=arr[i];
            }
            //向下调整
           shiftDownMax(ret,k,0);
            i++;
        }
        return  ret;
    }

    public  void shiftDownMax(int[] array, int size, int index) {
        int left=2*index+1;
        while(left<size){
            int max=left;
            int right=2*index+2;
            if(right<size&&array[right]>array[left]){
                max=right;
            }
            if(array[index]>array[max]){
                break;
            }
            swap(array,index,max);
            index=max;
            left=2*index+1;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
