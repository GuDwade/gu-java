class Person{
	public String name;
	public int age;
	public void show(){
		System.out.println("我叫"+name+",今年"+age+"岁");
	}
	public void isOlderThan(int anAge){
		boolean flg;
		if(age>anAge) System.out.println(name+"是成年人");
		else  System.out.println(name+"是未成年人");
		
	}
	public static void main(String[] args){
		Person Gu=new Person();
		Gu.name="顾成";
		Gu.age=17;
		System.out.println(Gu.name); 
		System.out.println(Gu.age);
		Gu.show();
		Gu.isOlderThan(18);
		System.out.println("=========="); 
		Person Li=new Person();
		Li.name="李四";
		Li.age=23;
		Li.show();
		Li.isOlderThan(18);
	}
}
