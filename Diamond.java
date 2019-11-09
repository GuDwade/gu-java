import java.util.Scanner;
public class Diamond{
	public static void printHellowRhombus(int size){
		if(size%2==0){
			size++;
		}
		for(int i=0;i<size/2+1;i++){
			for(int j=size/2+1;j>i+1;j--){
				System.out.print(" ");
			}
			for(int j=0;j<2*i+1;j++){
				if(j==0||j==2*i){
					System.out.print("*");
				}else{
					System.out.print(" ");
		 		}
			}
			System.out.println("");
		}
		for(int i=size/2+1;i<size;i++){
			for(int j=0;j<i-size/2;j++){
				System.out.print(" ");  
			}
			for(int j=0;j<2*size-2*i-1;j++){
				if(j==0||j==2*(size-i-1)){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
	public static void main(String[]args){	
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入菱形层数");
		int size=scan.nextInt();
		if(size%2==0){
			size++; 
		}
		for(int i=0;i<size/2+1;i++){
			for(int j=0;j<size/2-i;j++){
				System.out.print(" ");
			}
			for(int j=0;j<2*i+1;j++){
				if(j==0||j==2*i){
					System.out.print("*");
				}else{
				    System.out.print(" ");
				}
			}
			System.out.println("");
		}
		for(int i=0;i<size/2;i++){
			for(int j=0;j<i+1;j++){
				System.out.print(" ");
			}
			for(int j=0;j<size-2*(i+1);j++){
				if(j==0||j==size-2*(i+1)-1){
					System.out.print("*");
				}else{
				    System.out.print(" ");
				}
			}
			System.out.println("");
		}
		
		
	} 
}