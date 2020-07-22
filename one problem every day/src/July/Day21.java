package July;

public class Day21 {
    //旋转数组的最小数字
    public static int minArray(int[] numbers) {
        int left=0;
        int right=numbers.length-1;

        while (left<right){
            int mid=left+right>>1;
            if (numbers[mid]<numbers[right]){
                right=mid;
            }else if (numbers[mid]>numbers[right]){
                left=mid+1;
            }else{
                right--;
            }
        }

        return  numbers[left];
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[]{2, 2, 2, 0, 1,2}));
    }
}
