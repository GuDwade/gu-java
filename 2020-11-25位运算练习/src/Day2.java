public class Day2 {
    public int getSum(int a, int b) {
//        if (b == 0) {
//            return  a;
//        }
//        int sum = a ^ b;
//        int fac = (a & b) << 1;
//        return  getSum(sum,fac);

        while (b != 0){
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return  a;
    }


    public static int rangeBitwiseAnd(int m, int n) {
        int[] cnts = new int[32];
        int cnt = n - m + 1;

        for(int i = m; i <= n; i++) {
            int fac =31;
            int num = i;
            while (fac >= 0){
                cnts[fac] += (num & 1);
                num >>= 1;
                fac--;
            }
        }

        int ret = 0;
        for(int i =0; i <=31; i++ ) {
            ret <<= 1;
            if (cnts[i] == cnt){
                ret += 1;
            }
        }
        return  ret;
    }

    public int totalHammingDistance(int[] nums) {
        int res =0;
        int n = nums.length;
        for (int i = 0; i <= 31; i++){
           int ones = 0;
           for(int x : nums){
               ones += (x >> i) & 1;
           }
           res += ones * (n-ones);
        }
        return  res;
    }

    public int totalHammingDistance1(int[] nums) {
        int res =0;
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++){
                res += twoHammingDistance(nums[i],nums[j]);
            }
        }
        return  res;
    }

    private int twoHammingDistance(int num2, int num1) {
        if (num2 == num1) {
            return  0;
        }
        int num = num1 ^ num2;
        int cnt = 0;

        while (num > 0){
            cnt += num & 1;
            num >>=1;
        }

        return  cnt;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
    }
}
