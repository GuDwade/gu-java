
import java.util.Scanner;
import java.util.Stack;

public class Day27 {
    //验证密码合格  验证是否是低位数
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.nextLine();
            boolean flag=isFit(s);
            if (flag){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }

    }

    private static boolean isFit(String s) {
        if (s==null||s.length()<=8){
            return  false;
        }
        int a=0,b=0,c=0,d=0;
        for(char tmp:s.toCharArray()){
            if(tmp>='0'&&tmp<='9'){
                a=1;
            }else if(tmp>='a'&&tmp<='z'){
                b=1;
            }else if(tmp>='A'&&tmp<='Z'){
                c=1;
            }else{
                d=1;
            }
        }
        if (a+b+c+d<3){
            return  false;
        }
        //验证是否存在子串重复
        for(int i=0 ;i<s.length()-2 ;i++){
            String subStr =s.substring(i, i+3);
            if (s.substring(i+3).contains(subStr))
                return false;
        }
        return true;
    }

    private static  boolean isNumber(int N){
        int lowNum=0;
        if (N<10){
            lowNum=1;
        }else{
            lowNum=2;
        }
        int num=N*N;
        int sum=0;
        Stack<Integer>stack=new Stack<>();
        while (lowNum>0){
            stack.push(num%10);
            num=num/10;
            lowNum--;
        }
        while (!stack.isEmpty()){
            sum=sum*10+stack.pop();
        }
        return sum==N;
    }

    public static void lowNumber(){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int N=scanner.nextInt();
            boolean flag=isNumber(N);
            if (flag){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }
    }
}
