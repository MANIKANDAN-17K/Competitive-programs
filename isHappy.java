class Solution {
    public boolean isHappy(int n) {
        if( n < 0) return false;
        Set<Integer> s = new HashSet<>();
        int sum = Integer.MAX_VALUE;
        while(sum > 1){
            sum = sumSqure(n);
            if(s.contains(sum)){
                return false;
            }
            s.add(sum);
            n = sum;

        }
        if(sum == 1) return true;
        return false;
    }
    private int sumSqure(int n ){
        int sum = 0;
        int temp = n;
        while(temp > 0){
            int rem = temp % 10;
            sum += rem * rem;
            temp /= 10; 
        }
        return sum;
    }
}
