import java.util.Arrays;

public class Test {

    public static void insertSort(int[] array) {
        for(int i = 0; i < array.length - 1; i++ ){
            int val = array[i + 1];
            int end = i;
            for(; end >= 0 && array[end] > val; end-- ){
                array[end + 1] = array[end];
            }
            array[end + 1] = val;
        }
    }


    public static void shellSort(int[] array) {
        int gap = array.length;

        while (gap > 1){
            gap /= 2;
            for(int i = 0; i < array.length - gap; i++){
                int val = array[i + gap];
                int end = i;
                for(; end >= 0 && array[end] > val; end -= gap){
                    array[end + gap] = array[end];
                }
                array[end + gap] = val;
            }
        }
    }


    public static void quickSort(int[] array,int l, int r) {
        if (l >= r){
            return;
        }

        int mid = partion(array,l,r);
        quickSort(array,l, mid - 1);
        quickSort(array,mid + 1,r);

    }

    private static int partion(int[] array, int l, int r) {
        int val = array[l];

        int i = l ,j = r;

        while (i < j){

            while (i < j && array[j] >= val){
                j--;
            }

            while (i < j && array[i] <= val){
                i++;
            }

            if (i < j){
                swap(array,i,j);
            }
        }
        swap(array,i,l);
        return  l;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void mergeSort(int[] array) {
        int len = array.length;
        int[] helper = new int[len];
        merge(array,0,len - 1,helper);
    }

    private static void merge(int[] array, int l, int r, int[] helper) {
        if (l >= r){
            return;
        }

        int mid = l + r >> 1;
        merge(array,l,mid,helper);
        merge(array,mid + 1, r, helper);

        int i = l,j = mid + 1;
        int idx = l;
        while (i <= mid && j <= r){
            if (array[i] <= array[j]){
                helper[idx++] = array[i++];
            }else{
                helper[idx++] = array[j++];
            }
        }

        while (i <= mid){
            helper[idx++] = array[i++];
        }

        while (j <= r){
            helper[idx++] = array[j++];
        }

        for(int k = l; k <= r; k++){
            array[k] = helper[k];
        }

    }

    public static void bubbleSort(int[] array) {
        int len = array.length;
        for(int i = 0; i < len - 1; i++){
            boolean flag = true;
            for(int j = 0; j < len - 1 - i; j++){
                if (array[j] > array[j + 1]){
                    swap(array,j,j + 1);
                    flag = false;
                }
            }

            if (flag){
                break;
            }
        }
    }

    public static void selectSort(int[] array) {
        int end = array.length - 1;
        while (end > 0){
            int max = end;
            for(int i = end - 1; i >= 0; i--){
                if (array[i] > array[max]){
                    max = i;
                }
            }
            swap(array,max,end);
            end--;
        }

    }

    public static void heapSort(int[] array) {
        int len = array.length;
        for(int i = len - 2 / 2; i >= 0; i--){
            shiftDown(array,i,len);
        }

        for(int i = 0; i < len - 1; i++){
            swap(array,0,len - 1 - i);
            shiftDown(array,0,len - 1 - i);
        }
    }

    private static void shiftDown(int[] array, int i, int len) {
        int l = i * 2 + 1;

        while (l < len){
            int max = l;
            int r =  i * 2 + 2;

            if (r < len && array[r] > array[l]){
                max = r;
            }

            if (array[i] >= array[max]){
                break;
            }

            swap(array,i,max);
            i = max;
            l = i * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,11,5,2,6,1,7};
//        insertSort(arr);
//        shellSort(arr);
//        quickSort(arr,0,arr.length - 1);
//        mergeSort(arr);
//        selectSort(arr);
//        bubbleSort(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
