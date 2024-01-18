package TwoPointers;

public class TrappingRainWater {

    public int trap(int[] height) {
        if(height.length <=2){
            return 0;
        }
        int area = 0;
        int i = 1;
        while(i<height.length-1){
            int leftptr = i;
            int rightptr = i+1;
            int rightMax = height[rightptr];
            int rightptr2 = rightptr;
            while(leftptr-1 >= 0 && height[leftptr-1] > height[leftptr]){
                leftptr--;
            }
            while(rightptr <= height.length - 1 && height[rightptr] < height[leftptr]){
                if(height[rightptr] > rightMax){
                    rightMax = height[rightptr];
                    rightptr2 = rightptr;
                }
                rightptr++;
            }

            if(rightptr >= height.length){
                area += findArea(height,  leftptr, rightptr2);
                i = rightptr2 + 1;
            }else{
                area += findArea(height,  leftptr, rightptr);
                i = rightptr + 1;
            }
        }

        return area;
    }


    public int findArea(int[] height, int start, int end){
        int width = end - start - 1;
        int area = Math.min(height[start], height[end]) * width;
        for(int i = start+1; i<end; i++){
            if(height[i] > height[end]){
                area += height[i] - height[end];
            }
            area -= height[i];
        }
        return area;
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        System.out.println(trw.trap(new int[]{3,9,8,1,1,4,1,5,1,4,1,1,2}));
    }

}
