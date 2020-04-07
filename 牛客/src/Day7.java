import java.util.*;

public class Day7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int N=scanner.nextInt();
            if(N>1000){
                N=999;
            }
            int ret=delete(N);
            System.out.println(ret);
        }

    }
    public static int delete(int N){
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(i);
        }
        int idx=0;
        while(list.size()>1){
            idx=(idx+2)%list.size();
            list.remove(idx);
        }
        return list.get(0);
    }


    public static void topK(){
        LinkedList<Integer>list=new LinkedList<>();
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        int N=list.size()-1;
        int K=list.getLast();
        PriorityQueue<Integer>queue=new PriorityQueue<>(new IntegerCompartor());
        int i=0;
        while(i<N){
            if(queue.size()<K){
                queue.offer(list.get(i));
            }else{
                if(list.get(i)<queue.peek()){
                    queue.poll();
                    queue.offer(list.get(i));
                }
            }
            i++;
        }
        int[]arr=new int[K];
        for(int j=K-1;j>=0;j--){
            arr[j]=queue.poll();
        }
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
    public static void shiftDown(int index,int size,int[] arr){
        int left=index*2+1;
        while(left<size){
            int max=left;
            int right=index*2+1;
            while(right<size&&arr[right]>arr[left]){
                max=right;
            }
            if(arr[index]>=arr[max]){
                break;
            }
            swap(arr,index,max);
            index=max;
            left=index*2+1;
        }
    }

    public static void swap(int[]arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

}
class IntegerCompartor implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        int ret=o2-o1;
        if(ret>0){
            return 1;
        }else if(ret<0){
            return  -1;
        }else {
            return  0;
        }
    }
}
