import java.util.Scanner;

public class BankAccount {
	public static void main(String[] args) {
	Account gu=new Account("17050411103","顾富成",'男',10000);
	System.out.println("账号："+gu.id);
	System.out.println("姓名："+gu.user);
	System.out.println("性别：  "+gu.sex);
	boolean flag=true;
	do{
		gu.menu();
		Scanner function=new Scanner(System.in);
		int x=function.nextInt();
		switch(x){
			case 1:
				System.out.print("取款金额为：");
				int y=function.nextInt();
				gu.withdraw(y);
				break;
			case 2:
				System.out.print("存款金额为：");
				int z=function.nextInt();
				gu.deposit(z);
				break;
			case 3:
				gu.balance();
				break;
			case 0:
				System.out.println("退出账号");
				flag=false;
				break;
			default:
				System.out.println("输入错误，请重新输入");
				break;
		}
	}while(flag);
	}
}
class Account {
	String id;
	String user;
	char sex;
	float sum;
	Account(String i, String j, char k,int l) {
		id=i;
		user=j;
		sex=k;
		sum=l;
	}
	void menu(){
		System.out.println("****请选择您的操作****");
		System.out.println("******1.  取款    ****");
		System.out.println("******2.  存款    ****");
		System.out.println("******3.  查询    ****");
		System.out.println("******0.  退出    ****");
		
	}
	void withdraw(int a) {
		if(a>sum)
		{
			System.out.println("余额不足");
		}
		else
		{
			sum=sum-a;
			System.out.println("成功取款："+a);
		}
	}
	void deposit(int b) {
		sum=sum+b;
		System.out.println("成功存款："+b);
	}
	void balance() {
		System.out.println("剩余金额为："+sum);
	}
}