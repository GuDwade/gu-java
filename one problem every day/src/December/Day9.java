package December;

public class Day9 {
    //柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        int fives=0,tens=0;
        for(int b:bills){
            if (b==5){
                fives++;
            }else if (b==10){
                if (fives>0){
                    fives--;
                    tens++;
                }else{
                    return  false;
                }
            }else{
                int x=15;
                if (tens>0){
                    x-=10;
                    tens--;
                }
                while (x>0&&fives>0){
                    x-=5;
                    fives--;
                }
                if (x>0){
                    return  false;
                }
            }
        }

        return  true;
    }
}
