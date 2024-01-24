package Stack;

import java.util.Stack;

public class LargestAreaInHistogram {

    private static class Pair{
        int height;
        int index;
        Pair(int height, int index){
            this.height = height;
            this.index = index;
        }
    }

    public static int largestRectangleArea(int[] heights) {

        int area = 0, n = heights.length;
        int start;
        Stack<Pair> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            int curHt =heights[i];
            start = i;
            while(!stack.isEmpty() && stack.peek().height > curHt){
                Pair pair = stack.pop();
                int index = pair.index;
                int h = pair.index;
                area = Math.max(area, h * (i - index));
                start = index;
            }
            stack.push(new Pair(curHt, start));
        }

        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            int index = pair.index;
            int h = pair.height;
            area = Math.max(area, h * (n - index));
        }
        return area;
//
    }

    public static void main(String[] args) {
        System.out.println(LargestAreaInHistogram.largestRectangleArea(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
