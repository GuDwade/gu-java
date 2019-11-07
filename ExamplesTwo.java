public class ExamplesTwo{
	public static void yangHui(){
		int[][]triangle=new int[10][];
		for(int i=0;i<triangle.length;i++){
			triangle[i]=new int[i+1];//!!!
			for(int j=0;j<i+1;j++){
				if(i==0||j==0||j==i){
					triangle[i][j]=1;
				}else{
					triangle[i][j]=triangle[i-1][j]+triangle[i-1][j-1];
				}
				System.out.printf(triangle[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public static void jiuJIuTable(){
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.printf(i+"*"+j+"="+i*j+"\t");
			}
			System.out.println();
		}
	}
	public static void threeDight(){
		int count=0;   
		int[]a={1,2,3,4};
		System.out.println("满足条件的三位数是：");
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				if(j==i){
					continue;
				}
				for(int k=0;k<a.length;k++){
					if(k==j||k==i){
						continue;
					}
					for(int h=0;h<a.length;h++){
						if(h==k||h==j||h==i){
							continue;
						}
						count++;
						System.out.printf(a[j]*100+a[k]*10+a[h]+"\t");
					}
				}
			}
			
		}
        System.out.println();		
		System.out.println("总共有"+count+"个数符合条件");
		
	}
	public static void main(String[]args){
		// yangHui();
		// jiuJIuTable();
		threeDight();
		
	}
}