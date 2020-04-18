public class Day42 {
    //盛最多水的容器

    //暴力法
    public int maxArea(int[] height) {
        int max=0;
        for(int i=0;i<height.length;i++){
            for(int j=i;j<height.length;j++){
                max=Math.max(max,Math.min(height[i],height[j])*(j-i));
            }
        }
        return  max;
    }

    //双指针
    public int maxArea1(int[] height) {
        int left = 0, right = height.length - 1;
        int water = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            water = Math.max(water, area);
            if (height[left] <= height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return water;
    }

}
