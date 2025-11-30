class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int res = n;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        long total = 0;
        for(int num : nums){
            total+=num;
        }  
        int tot = (int) (total % p);
        if(tot == 0) return 0;
        long pre = 0;
        for(int i =0;i<n;i++){
            pre += nums[i];
            int cur = (int) (pre %p);
            int tar = (cur - tot +p ) %p;
            if(map.containsKey(tar)){
                int len = i - map.get(tar);
                res = Math.min(res,len);
            }
            map.put(cur,i);
        }
        return (res == n)? -1 : res;
    }
}
