import java.util.Arrays; 
public class Sort{
	public static int[] selectSort(int[]array,String str){
		if(str.equalsIgnoreCase("desc")){//从大到小
			for(int i=0;i<array.length;i++){
				for(int j=i+1;j<array.length;j++){
					if(array[i]<array[j]){
						int tmp=array[i];
						array[i]=array[j];
						array[j]=tmp;
					}
				}
			}
		}else if(str.equalsIgnoreCase("asc")){//从小到大
			for(int i=0;i<array.length;i++){
				for(int j=i+1;j<array.length;j++){
					if(array[i]>array[j]){
						int tmp=array[i];
						array[i]=array[j];
						array[j]=tmp;
					}
				}
			}
		}
		return array;
	}
	public static int getMid(int[]array,int left,int right){
		int tmp;
		int key=array[left];
		while(left<right){
			while(left<right&&array[right]>=key){
				right--;
			}
			tmp=array[right];
			array[right]=array[left];
			array[left]=tmp;
			while(left<right&&array[left]<=key){
				left++;
			}
			tmp=array[left]; 
			array[left]=array[right];
			array[right]=tmp;	
		}
		array[left]=key;
		return left; 
	}
	public static int[] quickSort(int[]array,int left,int right ){
		if(left<right-1){
			int mid=getMid(array,left,right);
			quickSort(array,left,mid-1);
			quickSort(array,mid+1,right);
		}
		return array;  
	}
	public static void main(String[]args){
	int[]a={3,2,456,76,75,43,21};
    selectSort(a,"desc");
    System.out.println(Arrays.toString(a));	
	selectSort(a,"asc");
    System.out.println(Arrays.toString(a));	
	int[] b={31,23,55,32,5,34,21,3,22};
	System.out.println(Arrays.toString(quickSort(b,0,b.length-1)));
	
	}
}