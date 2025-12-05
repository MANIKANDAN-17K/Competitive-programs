class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        int sum2 = 0;
        for(int i = 0;i<n-1;i++){
            sum = 0;
            sum2 = 0;
            for(int j = 0;j<=i;j++){
                sum+= nums[j];
            }
            for(int j=i+1;j<n;j++){
                sum2+=nums[j];
            }
            if(Math.abs(sum - sum2) % 2 == 0){
                count++;
            }
        }
        return count;
    }
}
