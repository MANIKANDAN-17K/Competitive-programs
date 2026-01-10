class Solution {
    public int maxProduct(int[] nums) {
        int fbig = 0;
        int sbig = 0;
        for(int n : nums){
            if(n > fbig){
                sbig = fbig;
                fbig = n;
            }else{
                sbig = Math.max(sbig,n);
            }
        }
        return (sbig -1 ) * (fbig - 1);
    }
}
