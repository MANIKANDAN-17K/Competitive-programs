class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int sum = 0;
        // int n = nums.length;
        for (int num : nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
      //  int m = freq.size();
        for (int num : freq.keySet()){
            int count = freq.get(num);
            if(count % k == 0){
                sum += num * count;
            }
        }
        return sum;
    }
}©leetcode
