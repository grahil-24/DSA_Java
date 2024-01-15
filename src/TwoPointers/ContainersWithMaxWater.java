package TwoPointers;

public class ContainersWithMaxWater {

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        while(start < end){
            int area = findArea(height[start], height[end], start, end);
            if(area > maxArea){
                maxArea = area;
            }
            if(height[start] <= height[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxArea;
    }

    public static int findArea(int h1, int h2, int i1, int i2){
        return (i2 - i1) * Math.min(h1, h2);
    }

    public static void main(String[] args) {
        int area = ContainersWithMaxWater.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6});
        System.out.println(area);
    }
}
