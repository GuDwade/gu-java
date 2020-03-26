public class Day20 {
    //车的可用捕获量
    public int numRookCaptures(char[][] board) {
        //定义上下左右四个方向
        int[]dx={0,0,-1,1};
        int[]dy={1,-1,0,0};
        int count=0;

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j]=='R'){
                    //遍历四个方向
                    for(int k=0;k<4;k++){
                        int x=i;
                        int y=j;
                        while(true){
                            //在一个方向上持续查找
                            x+=dx[k];
                            y+=dy[k];
                            //越界 遇到象
                            if(x<0||x>=8||y<0||y>=8||board[x][y]=='B'){
                                break;
                            }
                            if(board[x][y]=='p'){
                                count++;
                                break;
                            }
                        }
                    }
                    return count;
                }
            }
        }
        return  count;
    }
}
