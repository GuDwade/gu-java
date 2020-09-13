public class 二进制中1的个数 {
    public static int hammingWeight(int n) {
        int cnt=0;
        while (n!=0){
            cnt+=n&1;
            n>>>=1;
        }
        return  cnt;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(-5));
    }
}
