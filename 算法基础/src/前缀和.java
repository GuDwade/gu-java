import java.util.Scanner;

public class 前缀和 {
    // 从一开始 方便计算

    // 一维数组
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n + 1];
        int[][] questions = new int[m][2];

        for(int i = 1; i <= n; i++ ){
            arr[i] = scan.nextInt();
        }

        for(int i = 0; i < m; i++ ){
            questions[i][0] = scan.nextInt();
            questions[i][1] = scan.nextInt();
        }

        int[] ret = new int[n + 1];
        for(int i = 1; i <= n; i++ ){
            ret[i] = ret[i - 1] + arr[i];
        }

        for(int i = 0; i < m ;i++ ){
            System.out.println(ret[questions[i][1]] - ret[questions[i][0] - 1]);
        }
    }


    // 二维数组

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int q = scan.nextInt();
        int[][] arr = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++ ){
            for(int j = 1; j <= m; j++ ){
                arr[i][j] = scan.nextInt();
            }
        }

        int[][] ret = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++ ){
            for(int j = 1; j <= m; j++ ){
                ret[i][j] = ret[i - 1][j] + ret[i][j - 1] - ret[i - 1][j - 1] + arr[i][j];
            }
        }


        int[][] questions = new int[q][4];
        for(int i = 0; i < q; i++ ){
            questions[i][0] = scan.nextInt();
            questions[i][1] = scan.nextInt();
            questions[i][2] = scan.nextInt();
            questions[i][3] = scan.nextInt();
        }

        for(int i = 0; i < q; i++ ){
            int x1 = questions[i][0];
            int y1 = questions[i][1];
            int x2 = questions[i][2];
            int y2 = questions[i][3];
            System.out.println(ret[x2][y2] - ret[x2][y1 - 1] - ret[x1 - 1][y2] + ret[x1 - 1][y1 - 1]);
        }

    }
}
