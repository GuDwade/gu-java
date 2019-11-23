import java.util.Scanner;
public class JavaExamples{
	public static void letterChange(char a){
		if(a>='A'&&a<='Z'){
			a=(char)(a+32);//类型转换！！！！
			System.out.println((char)(a-32)+"被转换为"+a);
		}else if(a>='a'&&a<='z'){
			a=(char)(a-32);
			System.out.println((char)(a+32)+"被转换为"+a);
		}else{
			System.out.println("不在转换范围内");
		}
	}	
	public static void checkLogin(){
		Scanner input=new Scanner(System.in);
		System.out.println("请输入用户名");
		String name=input.nextLine();
		System.out.println("请输入密码");
		String password=input.nextLine();
		if(!name.equals("gufucheng")){
			System.out.println("用户名错误");
		}else if(!password.equals("123456")){
			System.out.println("密码错误");
		}else{
			System.out.println("登陆成功");
		}
	}
	public static int fac(int a){
		if(a==1){
			return a;
		}else{
			return a*fac(a-1);
		}
	}
	public static void sumPuls(){
		double sum=0;
		for(int i=1;i<=10;i++){
			sum+=1/(fac(i));
		}
		System.out.println("结果为"+sum);
	}
	
	public static void main(String[]args){
		// Scanner scanner=new Scanner(System.in);
		// System.out.println("请输入要转换的字母");
		// char a=scanner.next().charAt(0);
		// letterChange(a);
		// checkLogin();
		sumPuls();
		
	}
}