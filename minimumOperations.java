class Solution {
    public int minimumOperations(int[] nums) {
        int res = 0;
        for(int i : nums){
            if(i%3 != 0){
                res++;
            }
        }
        return res;
    }
}
