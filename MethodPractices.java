import java.util.Scanner;

public class MethodPractices{
	public static void judgePrime(int n){
		int i;
		for(i=2;i<n;i++){
			if(n%i==0){
				System.out.println(n+"是合数");
				break;
			}
		}
		if(i==n){
			System.out.println(n+"是素数");
		}	
	}
	public static void plus(){
		int sign=1;
		double sum=1;
		for(int i=2;i<100;i++){
			sign=-sign;
			double term=sign*(1/i);
			sum+=term;
		}
		System.out.println("sum="+sum);
	}
	
	public static void main(String[] args){
		// Scanner input=new Scanner(System.in);
		// System.out.println("请输入要判断的数");
		// int x=input.nextInt();
		// judgePrime(x);
		plus();
		
	}
}