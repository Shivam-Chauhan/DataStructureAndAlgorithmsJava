import java.util.Stack;

public class largestRectangleHistogram {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/problems/largest-rectangle-in-histogram/
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int maxArea=0,width;
        for(int i=0;i<=heights.length;i++){
            while(!stack.isEmpty() && (i==heights.length || heights[stack.peek()]>=heights[i])){
                int currIndex=stack.pop();
                int currHeight=heights[currIndex];
                width=0;
                if(stack.isEmpty()) width=i;
                else width=i-stack.peek()-1;
                maxArea=Math.max(maxArea,currHeight*width);
            }
            stack.add(i);
        }
        return maxArea;
    }
}

