public class ReserveNum {
    public static int reverse(int x) {
         int sum=x;
         int ret=0;
         int tmp=0;
        while(sum!=0){
            tmp=sum%10;
            if (ret > Integer.MAX_VALUE/10 || (ret == Integer.MAX_VALUE / 10 && tmp > 7))
                return 0;
            if (ret < Integer.MIN_VALUE/10 || (ret == Integer.MIN_VALUE / 10 && tmp < -8))
                return 0;
            ret=ret*10+tmp;
            ret=ret*10+tmp;
            sum=sum/10;
        }
        return  ret;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
