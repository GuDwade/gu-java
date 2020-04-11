
public class Day11 {

    //格雷码
    public String[] getGray(int n) {

        int m = 1<<n;
        String[] str = new String[m];
        if(n==1){
            str[0] = "0";
            str[1] = "1";
            return str;
        }
        String[] tmp = getGray(n-1);
        for(int i = 0;i<tmp.length;i++){
            str[i]="0"+tmp[i];
            str[m-1-i]="1"+tmp[i];
        }
        return str;
    }

    //无缓存交换
    public int[] exchangeAB(int[] AB) {
        AB[0]=AB[0]^AB[1];
        AB[1]=AB[0]^AB[1];
        AB[0]=AB[0]^AB[1];
        return AB;
    }



}
