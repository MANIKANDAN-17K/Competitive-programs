class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[] hist = new int[n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0){
                    if(matrix[i][j] == '1') hist[j] = 1;
                    else hist[j] = 0;
                }
                else{
                    if(matrix[i][j] == '1') hist[j] += 1;
                    else hist[j] = 0;
                }
            }
            int area = Area(hist);
            ans = Math.max(ans,area);
        }
        return ans;
    }
    private int Area(int[] height){
        int n = height.length;
        int maxArea = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i<=n;i++){
            int h = (i == n) ? 0 : height[i];
            while(!s.isEmpty()&& h < height[s.peek()]){
                int hgt = height[s.pop()];
                int width = s.isEmpty() ? i : i - s.peek() - 1;
                maxArea = Math.max(maxArea,hgt * width);
            }
            s.push(i);
        }
        return maxArea;
    }
}
