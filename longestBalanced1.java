
class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        Map<String, Integer> seen = new HashMap<>();
        int[] freq = new int[26];
        
        // Initialize with base state (all frequencies are 0)
        seen.put(getKey(freq), -1);
        
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
            String key = getKey(freq);
            
            if (seen.containsKey(key)) {
                maxLen = Math.max(maxLen, i - seen.get(key));
            } else {
                seen.put(key, i);
            }
        }
        
        return maxLen;
    }
    
    // Optimized key generation using StringBuilder
    private String getKey(int[] freq) {
        StringBuilder sb = new StringBuilder();
        int zFreq = freq[25];
        
        for (int i = 0; i < 25; i++) {
            sb.append(freq[i] - zFreq).append(',');
        }
        
        return sb.toString();
    }
}©leetcode
