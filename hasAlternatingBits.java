class Solution {
    public boolean hasAlternatingBits(int n) {
        String bits = Integer.toBinaryString(n);
        char[] arr = bits.toCharArray();
        for(int i = 1;i<arr.length;i++){
            if(arr[i] == arr[i-1]){
                return false;
            }
        }
        return true;
    }
}
