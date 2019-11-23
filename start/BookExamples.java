import java.util.Scanner;
public class BookExamples{
	public static void Grade(char n){
		switch(n){
			case 'A'://类型应该与n保持一致
				System.out.println(n+" is 90~100");
				break;
			case 'B'://字符''
				System.out.println(n+" is 80~90");
				break;
			case 'C':	
				System.out.println(n+" is 70~80");
				break;
			case 'D':
				System.out.println(n+" is 60~70");
				break;
			default:
			    System.out.println("请重新输入");
				break;
		}
	}
	public  static void jiaoGuCaiXiang(int x){
		int count =0;
		while(x!=1){
			System.out.println(" "+x);
			count++;
			if(x%2==1){
				x=x*3+1;
			}
			else{
				x=x/2;
			}
		}
		System.out.println(" "+x+"的运算次数"+count);
	}
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		// System.out.println("请输入成绩");
		// char n=input.next().charAt(0);//接受字符
		// Grade(n);
		System.out.println("请输入猜想数字");
		int x=input.nextInt();
		jiaoGuCaiXiang(x);
		
	}
}