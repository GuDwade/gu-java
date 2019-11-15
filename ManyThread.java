public class ManyThread{
	public static void main(String[]args){
		// ThreadTest test=new ThreadTest();
		// Thread t1=new Thread(test);
		// Thread t2=new Thread(test);
		// Thread t3=new Thread(test);
		// t1.start();
		// t2.start();
		// t3.start();
		
		ThreadTest2 t1=new ThreadTest2(1);
		t1.start(); 
		ThreadTest2 t2=new ThreadTest2(3);
		t2.start(); 
		ThreadTest2 t3=new ThreadTest2(5);
		t3.start(); 		
	}
}
class ThreadTest2 extends Thread{
	int num;
	ThreadTest2(){
		num=(int)(Math.random()*6000);
	}
	ThreadTest2(int num){
		this.num=num*1000;
	}
	public void run(){
	System.out.println(Thread.currentThread().getName()+' '+num);      
	try{
		Thread.sleep(num);
	}catch(InterruptedException e){}
	System.out.println(Thread.currentThread().getName()+"睡眠结束");
	}
}
class ThreadTest implements Runnable{
	int num;  
	ThreadTest(){
		num=(int)(Math.random()*6000);
	}
	ThreadTest(int num){
		this.num=num*1000;
	}
	public void run(){
	System.out.println(Thread.currentThread().getName()+' '+num);      
	try{
		Thread.sleep(num);
	}catch(InterruptedException e){}
	System.out.println(Thread.currentThread().getName()+"睡眠结束");
	}
}
 