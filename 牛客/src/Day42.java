import java.util.Scanner;
public class Day42 {
    //计算日期到天数转换
    static int[] days={0,31,28,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextInt()){
            int year=scan.nextInt();
            int month=scan.nextInt();
            int day=scan.nextInt();
            System.out.println(outDay(year,month,day));
        }

    }

    private static int outDay(int year, int month, int day) {
        if (month>12||month<=0||day>31||day<=0){
            return -1;
        }
        int ret=0;
        for(int i=1;i<month;i++){
            if (i==2&&isRun(year)){
                ret+=29;
            }else{
                ret+=days[i];
            }
        }
        ret+=day;
        return  ret;
    }

    public static boolean isRun(int year){
        return  (year%4==0&&year%100!=0)||year%400==0;
    }
}