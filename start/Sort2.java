import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Sort2{
	public static void directSort(double[]n){
		int i,j;
		for(i=2;i<n.length;i++){
			n[0]=n[i];
			for(j=i-1;j>0&&n[j]>n[0];j--){
				n[j+1]=n[j];
			}
			n[j+1]=n[0];
		}
	}
	public static void show(double[]arr){
		System.out.println("排序结果为");
		for(int i=1;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[]args){
		// int[]array=new int[10];
		// Random ran=new Random();
		// for(int i=0;i<array.length;i++){
			// array[i]=ran.nextInt(100);
		// }
		// System.out.println("未排序的数组为：");
		// System.out.println(Arrays.toString(array));
		// Arrays.sort(array);
		// System.out.println("排序的数组为：");
		// System.out.println(Arrays.toString(array));
		double[]num={0};
		Scanner scan=new Scanner(System.in);
		double newNum;
		System.out.println("输入0结束");
		while(true){
			System.out.println("\n输入合法数字");
			newNum=scan.nextDouble();
			if(newNum==0f){
				System.out.println("排序结束");
				break;
			}
		
		double[]tmp=new double[num.length+1];
		System.arraycopy(num,0,tmp,0,num.length);
		tmp[num.length]=newNum;
		num=tmp;
		directSort(num);
		show(num);
	}
	}
}