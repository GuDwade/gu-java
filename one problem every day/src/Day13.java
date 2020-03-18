public class Day13 {
    //矩形重叠
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        /*
        //1.根据坐标关系判断是否重叠
        //rec1分别在rec2的 左边     右边          上边             下边
        if(rec1[2]<=rec2[0]||rec1[0]>=rec2[2]||rec1[1]>=rec2[3]||rec1[3]<=rec2[1]){
            return  false;
        }
        return  true;
        */
        //2.根据坐标在数轴上的投影
        //横坐标 两矩形最小的右边的坐标>最大的左边的坐标
        //纵坐标 两矩形最小的上边的坐标>最大的下边的坐标
        if(Math.min(rec1[2],rec2[2])>Math.max(rec1[0],rec2[0])&&Math.min(rec1[3],rec2[3])>Math.max(rec1[1],rec2[1])){
            return  true;
        }
        return  false;
    }
}
