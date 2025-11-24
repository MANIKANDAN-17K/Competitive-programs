class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        ArrayList<Boolean> list = new ArrayList<>();
        int val = 0;
        for(int n : nums){
            val = ((val << 1) + n) % 5;
            list.add(val == 0);
        }
        return list;
    }
}
