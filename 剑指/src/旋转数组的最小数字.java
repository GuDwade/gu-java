public class 旋转数组的最小数字 {

    public int minArray(int[] numbers) {
        int n = numbers.length - 1;
        if(n < 0){
            return -1;
        }
        while(n > 0 && numbers[n] == numbers[0]){
            n--;
        }
        if(numbers[n] > numbers[0]){
            return numbers[0];
        }
        int l = 0;
        int r = n;

        while(l < r){
            int mid = l + r >> 1;
            if(numbers[mid] <= numbers[r]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return  numbers[l];
    }
}
