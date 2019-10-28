public class TradeNumber{
	public static void main(String args[]){
		int a=10;
		int b=20;
		System.out.println("a="+a);
		System.out.println("b="+b);
		int temp=0;
		temp=a;
		a=b;
		b=temp;
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("========");
		int c=11;
		int d=23;
		System.out.println("c="+c);
		System.out.println("d="+d);
		 c=c+d;
		 d=c-d;
		 c=c-d;
		System.out.println("c="+c);
		System.out.println("d="+d);
		System.out.println("========");
		int e=8;  //00001000
		int f=10; //00001010
		          //00000010 		  
		System.out.println("e="+e);
		System.out.println("f="+f);
		e=e^f;
		f=f^e;
		e=e^f;
		System.out.println("e="+e);
		System.out.println("f="+f);
	}
}