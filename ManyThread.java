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
public class ManyThread{
	public static void main(String[]args){
        Thread t=new ThreadTest2();
		Thread t1=new Thread(t);
		t1.start(); 
		Thread t2=new Thread(t);
		t2.start(); 
		Thread t3=new Thread(t);
		t3.start(); 		
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

 