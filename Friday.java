import java.io.*;
import java.util.*;
public class Friday{
	public static void sequence()throws Exception{
		String m=new String("");
		int[]a={0,0,0};
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("输入三个数字（以一个空格隔开）");
		m=stdin.readLine();
		Scanner scan=new Scanner(m);
		for(int i=0;i<a.length;i++){
			a[i]=scan.nextInt();
		}
		Arrays.sort(a);
		for(int i=0;i<a.length;i++){
			System.out.printf("%d\t",a[i]);
		}
	}
	public static void password()throws Exception{
		System.out.println("输入需要加密的电话号码");
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s=stdin.readLine();
		char[]a=s.toCharArray();
		int[]b=new int[a.length];
		for(int i=0;i<a.length;i++){
			b[i]=((a[i]-'0')+5)%10;
		}
		System.out.println("加密后的数字为");
		for(int i=b.length-1;i>=0;i--){
			System.out.print(b[i]);
		}
		
	}
	public static void main(String[]args)throws Exception{
		// password();
		//sequence();
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入你要测试的字符串");
		String str=scan.nextLine();
		Scanner scan1=new Scanner(System.in);
		System.out.println("请输入你要查找的字符串");
		String str1=scan1.nextLine();
		int count=0;
		int start=0;
		while(str.indexOf(str1,start)>=0&&start<str.length()){
			count++;
			start=str.indexOf(str1,start)+str1.length();
		}
		System.out.println(str1+"在"+str+"中出现的次数"+count);
	}
} 