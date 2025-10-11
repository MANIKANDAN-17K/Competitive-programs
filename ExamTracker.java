import java.util.*;

class ExamTracker {

    private TreeMap<Integer, Long> prefix; // time → prefix sum

    public ExamTracker() {
        prefix = new TreeMap<>();
    }
    
    public void record(int time, int score) {
        // Find current total up to previous time
        long prevSum = 0;
        Map.Entry<Integer, Long> prev = prefix.floorEntry(time);
        if (prev != null) prevSum = prev.getValue();

        // Update prefix sums for all times >= time
        // To avoid O(n) updates, we store deltas
        // So we need an auxiliary map of actual records
        long added = prefix.getOrDefault(time, prevSum) + score;
        prefix.put(time, added);
    }
    
    private long prefixSum(int time) {
        Map.Entry<Integer, Long> e = prefix.floorEntry(time);
        return (e == null) ? 0 : e.getValue();
    }
    
    public long totalScore(int startTime, int endTime) {
        if (prefix.isEmpty()) return 0;
        return prefixSum(endTime) - prefixSum(startTime - 1);
    }
}
©leetcode
