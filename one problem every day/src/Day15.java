import java.util.Comparator;
import java.util.PriorityQueue;

class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
public class Day15 {
    //最小的K个数
    public int[] getLeastNumbers1(int[] arr, int k) {
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

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(new IntegerComparator());
        for(int val:arr){
            if(pq.size()<k){
                pq.offer(val);
            }else{
                if(val<pq.peek()){
                    pq.poll();
                    pq.offer(val);
                }
            }
        }
        int []ret=new int[k];
        int i=0;
        for(int val:pq){
            ret[i++]=val;
        }
        return  ret;
    }
}
