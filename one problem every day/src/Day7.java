public class Day7 {
    //字符串最大公因子
    public static String gcdOfStrings(String str1, String str2) {

        if(!(str1+str2).equals(str2+str1)){
            return "";
        }

        return str1.substring(0,gcd(str1.length(),str2.length()));
    }

    //最大公约数
    public static int gcd(int a,int b){
        /*
        while(a%b!=0){
            int tmp=a%b;
            a=b;
            b=tmp;
        }
        return b;
        */
        return a%b==0?b:gcd(b,a%b);
    }
    //最小公倍数
    public  static int  min(int a,int b){
        //两数相乘除以最大公约数
        return  a*b/gcd(a,b);

    }

    public static void main(String[] args) {
        System.out.println(gcd(16,24));
        System.out.println(min(16,24));
        System.out.println(gcdOfStrings("ABCABC","ABC"));
    }
}
