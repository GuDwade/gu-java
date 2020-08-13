package August;

public class Day11 {
    //字符串相乘
    //123
    //456
    public static String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int n1=num1.length();
        int n2=num2.length();

        String ret="";

        for(int i=n2-1;i>=0;i--){
            int x=num2.charAt(i)-'0';
            int add=0;
            int sum=0;
            StringBuilder sb=new StringBuilder();
            for(int fac=n2-1;fac>i;fac--){
                sb.append(0);
            }
            for(int j=n1-1;j>=0;j--){
                int y=num1.charAt(j)-'0';
                sum=(x*y+add)%10;
                add=(x*y+add)/10;
                sb.append(sum);
            }
            if (add>0){
                sb.append(add);
            }
            ret=addTwoSum(ret,sb.reverse().toString());
        }
        return  ret;
    }

    private static String addTwoSum(String num1, String num2) {
        int n1=num1.length()-1;
        int n2=num2.length()-1;
        int add=0;
        StringBuilder sb=new StringBuilder();
        while (n1>=0||n2>=0){
            int x=n1>=0?num1.charAt(n1)-'0':0;
            int y=n2>=0?num2.charAt(n2)-'0':0;

            int sum=(x+y+add)%10;
            add=(x+y+add)/10;
            sb.append(sum);
            n1--;
            n2--;
        }
        if (add>0){
            sb.append(add);
        }
        return  sb.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
