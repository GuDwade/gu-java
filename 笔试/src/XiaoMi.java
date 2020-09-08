import java.util.Arrays;

public class XiaoMi {
    static String[] pokersort(String[] pokers) {

        int[]count=new int[13];
        for(String str:pokers){
            str=str.trim();
            if (str.equals("1")){
                count[0]++;
            }else if (str.equals("2")){
                count[1]++;
            }else if (str.equals("3")){
                count[2]++;
            }else if (str.equals("4")){
                count[3]++;
            }else if (str.equals("5")){
                count[4]++;
            }else if (str.equals("6")){
                count[5]++;
            }else if (str.equals("7")){
                count[6]++;
            }else if (str.equals("8")){
                count[7]++;
            }else if (str.equals("9")){
                count[8]++;
            }else if (str.equals("10")){
                count[9]++;
            }else if(str.equals("J")){
                count[10]++;
            }else if(str.equals("Q")){
                count[11]++;
            }else if(str.equals("K")){
                count[12]++;
            }

        }
        int r=pokers.length-1;
        for(int i=1;i>=0;i--){
            while (count[i]!=0){
                pokers[r--]=String.valueOf((i+1));
                count[i]--;
            }
        }

        while (count[12]!=0){
            pokers[r--]="K";
            count[12]--;
        }

        while (count[11]!=0){
            pokers[r--]="Q";
            count[11]--;
        }

        while (count[10]!=0){
            pokers[r--]="J";
            count[10]--;
        }

        for(int i=9;i>=2;i--){
            while (count[i]!=0){
                pokers[r--]=String.valueOf((i+1));
                count[i]--;
            }
        }

        return  pokers;



    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pokersort(new String[]{"1", "2","3","4" ,"J","9", "2"})));
    }

}
