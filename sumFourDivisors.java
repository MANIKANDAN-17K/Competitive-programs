class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum+=result(nums[i]);
        }
        return sum;
    }
    private int result(int x){
        int sum = 0;
        int cnt = 0;
        for(int i = 1;i<= x;i++){
            if( x % i == 0){
               cnt++;
               sum += i;
            }
            if(cnt == 5) return 0;
        }
        if(cnt < 4) return 0;
        return sum;
    }
}
