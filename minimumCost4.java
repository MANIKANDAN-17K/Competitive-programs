class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        long res = Long.MAX_VALUE;
        long winSum = 0L;
        TreeSet<Integer> using = new TreeSet<>(
            (a,b) -> nums[a] == nums[b] ? a -b :nums[a] - nums[b]
        );
        TreeSet<Integer> waiting = new TreeSet<>(
            (a,b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]
        );
        for(int i = 1;i<= dist + 1 ;i++){
            using.add(i);
            winSum += nums[i];
        }
        while(using.size() > k - 1){
            int idx = using.pollLast();
            winSum -= nums[idx];
            waiting.add(idx);
        }
        res = Math.min(res,winSum);
        for(int i = 1;i+dist+1 < n;i++){
            waiting.add(i+dist+1);
            if(using.contains(i)){
                using.remove(i);
                winSum -= nums[i];
                int idx = waiting.pollFirst();
                using.add(idx);
                winSum += nums[idx];
            }else{
                waiting.remove(i);
                int v = waiting.first();
                int u = using.last();
                if(nums[v] < nums[u]){
                    using.remove(u);
                    waiting.add(u);
                    winSum -= nums[u];
                    waiting.remove(v);
                    using.add(v);
                    winSum += nums[v];
                }
            }
            res = Math.min(res,winSum);
        }
        return res + nums[0];
    }
}
