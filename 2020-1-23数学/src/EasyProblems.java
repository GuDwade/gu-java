public class EasyProblems {
    //2 的幂次方
    public static boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        if(n > 0 && (n & (n - 1)) == 0){
            return true;
        }
        return false;
    }
    //3的幂次方  万能公式
    public static  boolean isPowerOfThree(int n) {
        if(n<1){
            return false;
        }
        while(n%3==0){
            n=n/3;
        }
        return n==1;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(14));
        System.out.println(isPowerOfThree(27));
    }
}
