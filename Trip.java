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
public class Trip{
	public static void main(String[] args){
		// Travel tar1=new Travel("成都");
		// tar1.start();
		// Travel tar2=new Travel("西安");
		// tar2.start();
		TravelCon con1=new TravelCon("兰州");
		Thread thr1=new Thread(con1);
		thr1.start();
		TravelCon con2=new TravelCon("北京");
		Thread thr2=new Thread(con2);
		thr2.start();
	}
}  