import java.util.Scanner;

public class Day23 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int student=scanner.nextInt();
            int operation=scanner.nextInt();
            int[]grades=new int[student+1];
            for (int i=1;i<=student;i++){
                grades[i]=scanner.nextInt();
            }
            for (int i=0;i<operation;i++){
                char tmp=scanner.next().charAt(0);
                if (tmp=='Q'){
                    int a=scanner.nextInt();
                    int b=scanner.nextInt();
                    int start=Math.min(a,b);
                    int end=Math.max(a,b);
                    int max=grades[start];
                    for(int j=start+1;j<=end;j++){
                        if (grades[j]>max){
                            max=grades[j];
                        }
                    }
                    System.out.println(max);
                }
                if (tmp=='U'){
                    int id=scanner.nextInt();
                    int grade=scanner.nextInt();
                    grades[id]=grade;
                }

            }
        }



    }

    public static void game(){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int num=scanner.nextInt();
            int start=scanner.nextInt();
            int []arr=new int[num];
            for(int i=0;i<num;i++){
                arr[i]=scanner.nextInt();
            }

            for(int n:arr){
                if (n<=start){
                    start+=n;
                }else{
                    start+=gcd(start,n);
                }
            }
            System.out.println(start);
        }
    }
    private static int gcd(int start, int n) {
        return  n==0?start:gcd(n,start%n);
    }
}
