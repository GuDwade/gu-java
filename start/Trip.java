
class TravelCon implements Runnable{
	private String cityName;
	TravelCon(String cityName){
		this.cityName=cityName; 
	}
	public void run(){
		for(int i=1;i<=10;i++){
			System.out.println(i+":"+cityName);
			try{
			Thread.sleep(500);
		}catch(InterruptedException e){}
		}
	}
}
class Travel extends Thread{
	private String city;
	Travel(String city){
		this.city=city;
	}
	public void run(){
		for(int i=1;i<=10;i++){
			System.out.println(i+":"+city);
			try{
			Thread.sleep(500);
		}catch(InterruptedException e){}
		}
	}
}
public class Trip{
	public static void main(String[] args){
		Thread t1=new Travel("成都");
		t1.start();
		Thread t2=new Travel("西安");
		t2.start();
	}
}

