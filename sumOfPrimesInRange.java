class Solution {
    private boolean isPrime(int n){
        if(n <= 1) return false;
        if(n<=3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        for(int i = 5;i*i<=n;i+=6){
            if(n%i == 0 || n%(i+2) == 0){
                return false;
            }
        }
        return true;
    }
    public int sumOfPrimesInRange(int n) {
        String str = n+"";
        int sum = 0;
        int r = Integer.parseInt(new StringBuilder(str).reverse().toString());
        for(int i = Math.min(n,r);i<=Math.max(n,r);i++){
            if(isPrime(i)) sum += i;
        }
        return sum;
    }
}©leetcode
