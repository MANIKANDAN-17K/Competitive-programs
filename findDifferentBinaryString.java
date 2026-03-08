class Solution {
    int n;
    HashSet<String> num = new HashSet<>();
    public String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        for(String s : nums){
            num.add(s);
        }
        return generate("");
    }
    private String generate(String s){
        if(s.length() == n){
            if(!num.contains(s)) return s;
            return "";
        }
        String zero = generate(s+"0");
        if(zero.length() > 0){
            return zero;
        }
        return generate(s+"1");
    }
}
