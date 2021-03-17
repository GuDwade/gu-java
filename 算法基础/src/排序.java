import java.util.Scanner;

public class 排序 {

    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }
        quickSort(arr,0,n-1);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] +" ");
        }
    }

    public static void quickSort(int[] arr,int l ,int r){
        if(l >= r){
            return;
        }
        int mid = partion(arr,l,r);
        quickSort(arr,l,mid - 1);
        quickSort(arr,mid + 1,r);
    }

    public static int partion(int[] arr, int l, int r){
        int val = arr[l];
        int begin = l ;
        int i = l , j = r;

        while(i < j){
            while(i < j && arr[j] >= val){
                j--;
            }

            while(i < j && arr[i] <= val){
                i++;
            }

            if(i < j){
                swap(arr,i,j);
            }
        }
        swap(arr,begin,i);
        return i;
    }

    public static void swap(int[] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
