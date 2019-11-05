import java.util.Scanner;
import java.util.Random;
public class BookContinue{
	public static void  charVaule(char n){
		if(n!='#')
			System.out.println(n+"的Ascii值为："+(int)n);
	}
	public static int maxDiv(int a){
		int i=a-1;
		while(i>0){
			if(a%i==0){
				break;
			}
			i--;
		}
		return i; 
	}
	public static void randomNum(){
		int[]a=new int[7];
		for(int i=0;i<a.length;i++){
			one_mun:
			while(true){
				a[i]=(int)(Math.random()*33)+1;
				for(int j=0;j<i;j++){
					if(a[i]==a[j]){
						continue one_mun;
					}
				}
				break;
			}
		}
		for(int i=0;i<a.length;i++){
			System.out.println(" "+a[i]);
		}
	}
	public static void main(String[]args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入");
		// char c=scanner.next().charAt(0);
		// charVaule(c);
		// int b=scanner.nextInt();
		// System.out.println(b+"的最大约数是："+maxDiv(b));
		randomNum();
		
	}
}