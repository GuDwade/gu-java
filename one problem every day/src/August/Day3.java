package August;

public class Day3 {
    //字符串相加
    public String addStrings(String num1, String num2) {
        int n=num1.length();
        int m=num2.length();

        int i=n-1;
        int j=m-1;
        int fac=0;
        StringBuilder sb=new StringBuilder();

        while (i>=0||j>=0){
            int x=i>=0?num1.charAt(i)-'0':0;
            int y=j>=0?num2.charAt(j)-'0':0;

            int sum=(x+y+fac)%10;
            fac=(x+y+fac)/10;

            sb.append(sum);
            i--;
            j--;
        }
        if (fac>0){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Day3 test=new Day3();
        System.out.println(test.addStrings("99", "9"));
    }
}
