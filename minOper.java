class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int one = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == 1) one++;
        }
        if(one > 0) return n - one;

        int ans = Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            int g = nums[i];
            for(int j = i+1;j<n;i++){
                g = gcd(g,nums[j]);
                if(g == 1){
                    ans = Math.min(ans,j - i);
                    break;
                }
            }
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans + n -1;
    }
    private int gcd(int a, int b){
        while(b != 0){
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}

------------------------------------------------------------
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int one = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == 1) one++;
        }
        if(one > 0) return n - one;
        int g = 0;
        for(int x : nums) g = gcd(g,x);
        if(g>1) return -1;
        int best = Integer.MAX_VALUE;
        for(int i = 0; i<n ;i++){
            int cur = 0;
            for(int j = i;j<n;j++){
                cur = gcd(cur,nums[j]);
                if(cur == 1){
                    best = Math.min(best,j-i+1);
                    break;
                }
            }
        }
        return (best - 1) + (n - 1);
    }
    private int gcd(int a, int b){
        while(b != 0){
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }
}
