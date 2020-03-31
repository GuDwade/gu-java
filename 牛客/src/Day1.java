import java.util.Scanner;

public class Day1 {
    //喝汽水
    public static int bootle(int x){
        if(x<2){
            return 0;
        }
        if(x==2){
            return 1;
        }
        int full=x/3;
        int empty=x%3+full;
        return full+bootle(empty);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x=scanner.nextInt();
            System.out.println(bootle(x));
        }

    }
}
