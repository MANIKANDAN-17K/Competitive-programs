class Solution {
    public int maxTwoEvents(int[][] events) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(Pair :: getKey)
        );
        Arrays.sort(events,(a,b) -> a[0] - b[0]);
        int MaxVal = 0,MaxSum = 0;
        for(int[] event : events){
            while(!pq.isEmpty() && pq.peek().getKey() < event[0]){
                MaxVal = Math.max(MaxVal,pq.peek().getValue());
                pq.poll();
            }
            MaxSum = Math.max(MaxSum,MaxVal + event[2]);
            pq.add(new Pair<>(event[1],event[2]));
        }
        return MaxSum;
    }
}
