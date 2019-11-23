public class MyDate{
	private int day=12;
	private int month=6;
	private int year=2019;
	public MyDate(int y,int m,int d){
		year=y;
		month=m;
		day=d;
	}
	void addYear(){
		year++;
	}
	public void display(){
		System.out.println(year+"-"+month+"-"+day);
	}
	public static void main(String[]args){
		MyDate m,n;
		m=new MyDate(2019,11,5);
		n=m;
		n.addYear();//m,n引用的对象相同，结果相同
		m.display();
		n.display();
	}
}