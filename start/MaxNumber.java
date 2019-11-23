public class MaxNumber{
	public static void main(String args[]){
		int a[]={9,3,10};
		int i;
		int j;
		for(i=0;i<2;i++){
			for(j=0;j<2-i;j++){
				int tmp;
				if(a[j]>a[j+1]){
					tmp=a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
				}
			}
				
		}
		System.out.println("Max="+a[2]);
		System.out.println("Min="+a[0]);
	}
}