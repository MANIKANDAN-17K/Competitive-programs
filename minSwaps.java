class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zero = new int[n];
        for(int i = 0;i<n;i++){
            int cnt = 0;
            for(int j =  n -1 ;j>=0 && grid[i][j] == 0;j--){
                cnt++;
            }
            zero[i] = cnt;
        }
        int swap = 0;
        for(int i = 0;i<n;i++){
            int need = n - i - 1;
            int j = i; 
            while( j < n && zero[j] < need) j++;
            if(j == n ) return -1;
            while(j > i){
                int temp = zero[j];
                zero[j] = zero[j-1];
                zero[j-1] = temp;
                j--;
                swap++;
            }
        }
        return  swap;
    }
}
