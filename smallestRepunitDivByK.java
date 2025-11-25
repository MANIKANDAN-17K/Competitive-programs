class Solution {
    public int smallestRepunitDivByK(int k) {
        int ret = 0;
        for (int i = 1;i<= k ;i++){
            ret = (ret * 10 + 1) % k;
            if(ret == 0){
                return i;
            }
        }
        return -1;
    }
}
