package Stack;

public class RectangleHistogram {

    public int largestRectangleArea(int[] heights) {
        int largestNum = 0;
        for(int i =0; i < heights.length; i++){
            int area  = findArea(heights, i);
            if(area > largestNum){
                largestNum = area;
            }
        }

        return largestNum;
    }

    public int findArea(int[] heights, int index){
        int count = 1;
        for(int i = index-1; i>=0; i--){
            if(heights[i] >= heights[index]){
                count++;
            }else{
                break;
            }
        }
        for(int i = index + 1; i<heights.length; i++){
            if(heights[i] >= heights[index]){
                count++;
            }else{
                break;
            }
        }

        return count * heights[index];
    }

    public static void main(String[] args) {

        RectangleHistogram rectangleHistogram = new RectangleHistogram();
        System.out.println(rectangleHistogram.largestRectangleArea(new int[]{2, 4}));
    }
}
