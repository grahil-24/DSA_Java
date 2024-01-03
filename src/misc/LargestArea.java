package misc;

public class LargestArea {

    public int maxArea(int[] height){

        int length = height.length-1;
        int area = 0;
        int maxArea = -1;
        for(int i=0; i<length; i++){
            for(int j = i+1; j<=length; j++){
                if(height[j] < height[i]){
                    area = (j - i) * height[i];
                    if(area > maxArea){
                        maxArea = area;
                    }
                    break;
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

    }
}
