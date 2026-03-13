class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxWorkerTime = 0;
        for (int t : workerTimes){
            maxWorkerTime = Math.max(maxWorkerTime,t);
        }
        long l = 1;
        long r = ((long) maxWorkerTime * mountainHeight * (mountainHeight + 1))/2;
        long ans = 0;
        while (l <= r){
            long mid = (l+r)/2;
            long cnt = 0;
            for(int t : workerTimes){
                long work = mid / t;
                long k = (long) ((-1.0 + Math.sqrt(1 + work * 8))/2 + 1e-7);
                cnt += k;
            }
            if(cnt >= mountainHeight){
                ans = mid;
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}
