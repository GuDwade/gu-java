package June;

public class Day2 {

    //求1+2+…+n

    public int sumNums1(int n) {
        return  (int)(Math.pow(n,2)+n)>>1;
    }

    public int sumNums(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        Day2 test=new Day2();
        System.out.println(test.sumNums(5));
    }
}
