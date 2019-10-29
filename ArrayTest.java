public class ArrayTest{
	public static void main(String []args){
		int a[]=new int[5];
		int i;
		for(i=0;i<a.length;i++){
			a[i]=2*(i+1);
		}
		for(i=0;i<a.length;i++){
			System.out.println("a["+i+"]="+a[i]);
		}
		System.out.println("==========");
		int b[]={2,4,6,8,10};//初始化不用指定大小
		for(i=0;i<b.length;i++){
			System.out.println("b["+i+"]="+b[i]);
		}
		System.out.println("==========");
		int  f[]=new int [10];
		f[0]=f[1]=1;
		int j;
		for(j=2;j<f.length;j++){
			f[j]=f[j-1]+f[j-2];
		}
		for(j=0;j<f.length;j++){
			System.out.println("f["+j+"]="+f[j]);
		}
		System.out.println("==========");
		int l,m;
		int x[][]={{1,3,5},{2,4,6}};
	    for(l=0;l<2;l++){
			for(m=0;m<3;m++){
				System.out.print(x[l][m]+" ");
			}
			System.out.println();
		}
		System.out.println("==========");
		int z[][]=new int [2][4];
		for(l=0;l<2;l++){
			for(m=0;m<4;m++){
					z[l][m]=l+m+1;
			}
		}
		
		for(l=0;l<2;l++){
			for(m=0;m<4;m++){
				System.out.print(z[l][m]+" ");
			}
			System.out.println();
		}	
		
	}
}