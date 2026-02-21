class Solution {
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for(int i = left;i <= right;i++){
            String bits = Integer.toBinaryString(i);
            int cnt = 0;
            for(int j = 0;j<bits.length();j++){
                if(bits.charAt(j) == '1'){
                    cnt++;
                }
            }
            if(isPrime(cnt)){
                res++;
            }
        }
        return res;
    }
    private boolean isPrime(int i){
        if(i <= 1) return false;
        for(int j = 2;j<= i/2;j++){
            if(i % j == 0)
                return false;
        }
        return true;
    }
}
