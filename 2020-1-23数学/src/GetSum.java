public class GetSum {
    public static int getSum(int a, int b) {
        int tmp=a^b;
        int ret=(a&b)<<1;
        if(ret==0){
            return tmp;
        }else{
            return getSum(tmp,ret);
        }
    }

    /*public static int guessNumber(int n) {
        int l = 1;
        int r = n;
        int mid = l + (r - l)/2;
        while(l <= r){
            if(guess(mid) == -1){
                r = mid - 1;
                mid = l + (r - l)/2;
            }else if(guess(mid) == 1){
                l = mid + 1;
                mid = l + (r - l)/2;
            }else{
                return mid;
            }
        }
        return 1;
    }
    */

    public static void main(String[] args) {
        System.out.println(getSum(101,259));
    }
}
