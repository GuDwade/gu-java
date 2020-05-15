import java.util.Scanner;

public class Day31 {
    //找钱
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String p=scanner.next();
            String a=scanner.next();
            printOut(p,a);
        }

        System.out.println(numberOf2sInRange(25));

    }

    private static void printOut(String p, String a) {
        String []pNum=p.split("\\.");
        String []aNum=a.split("\\.");
        int[]pInt=new int[3];
        int[]aInt=new int[3];
        for(int i=0;i<pNum.length;i++){
            pInt[i]=Integer.valueOf(pNum[i]);
        }
        for(int j=0;j<aNum.length;j++){
            aInt[j]=Integer.valueOf(aNum[j]);
        }
        int ret[]=new int[3];
        if(aInt[0]>=pInt[0]){
            if (aInt[2]>=pInt[2]){
                ret[2]=aInt[2]-pInt[2];
            }else{
                ret[2]=aInt[2]-pInt[2]+29;
                aInt[1]-=1;
            }
            if (aInt[1]>=pInt[1]){
                ret[1]=aInt[1]-pInt[1];
            }else{
                ret[1]=aInt[1]-pInt[1]+17;
                aInt[0]-=1;
            }
            ret[0]=aInt[0]-pInt[0];
            System.out.print(ret[0]+"."+ret[1]+"."+ret[2]);
        }else{
            if (aInt[2]>=pInt[2]){
                ret[2]=aInt[2]-pInt[2];
            }else{
                ret[2]=aInt[2]-pInt[2]+29;
                aInt[1]-=1;
            }
            if (aInt[1]>=pInt[1]){
                ret[1]=aInt[1]-pInt[1];
            }else{
                ret[1]=aInt[1]-pInt[1]+17;
                aInt[0]-=1;
            }
            ret[0]=aInt[0]-pInt[0];
            System.out.print(ret[0]+"."+ret[1]+"."+ret[2]);
        }
    }

    //2的个数
    public static int countNumberOf2s(int n) {
       int count=0;
       for(int i=1;i<=n;i++){
           int tmp=i;
           while (tmp>0){
               if (tmp%10==2){
                   count++;
               }
               tmp/=10;
           }
       }
       return count;
    }
    //每十位数里会出现一个 2。但 2x 是个例外，会多出现 10 个 2 也就是每百位数里会出现 20 个 2。（2、12、22、
    //32...92 + 20、21、22...29）。但 2xx 是个例外，会多出现 100 个 2 依次类推即可根据 n 的值直接得出 2 的个数。
    public static int numberOf2sInRange(int n) {
        int count = 0; // 最终 2 的个数
        int factor = 1; // 从低位到高位计算 2 的个数
        int low = 0; // 屏蔽掉低位
        int current = 0; // 当前计算位数的值
        int high = 0; // 计算高位
        while(n / factor != 0) {
            low = n - (n / factor) * factor;
            current = (n / factor) % 10;
            high = n / (factor * 10);
            // 根据当前的
            switch(current){
                case 0:
                case 1:
                    //<2  如101个数只会出现 10个2 （0-9）+2，不会出现102
                    count += high * factor;
                    break;
                case 2:
                    //=2 如122  计算十位时  （20~ 29）10 个 和 120 121 122
                    //高位*当前位置2的个数+不满当前位置的个数
                    count += high * factor + low + 1;
                    break;
                default:
                    //>2  23 (2 12 22)
                    count += (high + 1) * factor;
                    break;
            }
            factor *= 10;
        }
        return count;
    }

}
