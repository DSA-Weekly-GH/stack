public class Balde {

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] newheights = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            newheights[i] = heights[i];
        }
        newheights[heights.length] = 0;
        heights = newheights;
        int[] stack = new int[heights.length];
        int top = -1;
        for (int i = 0; i < heights.length; i++) {
            while (top != -1 && heights[stack[top]] >= heights[i]) {
                int h = heights[stack[top--]];
                int w = top == -1 ? i : i - stack[top] - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack[++top] = i;
        }
        return maxArea;
    }
    public static void main(String[] args) {
        Balde b = new Balde();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(b.largestRectangleArea(heights));
    }
}
