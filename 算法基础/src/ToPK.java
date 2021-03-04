import java.util.Scanner;

public class ToPK {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }

        int ret = quickSort(arr,0,n - 1, k);
        System.out.println(ret);
    }

    private static int  quickSort(int[] arr, int l, int r, int k) {
        if (l == r){
            return  arr[l];
        }

        int i = l , j = r;
        int val = arr[l];
        int begin = l;

        while (i < j){
            while (i < j && arr[j] >= val){
                j--;
            }

            while (i < j && arr[i] <= val){
                i++;
            }

            if (i < j){
                swap(arr,i,j);
            }
        }
        swap(arr,begin,i);
        int sum = i - begin + 1;
        if (sum >= k){
            return  quickSort(arr,l,i,k);
        }else{
            return quickSort(arr,j + 1,r,k - sum);
        }
    }

    public static void swap(int[] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

