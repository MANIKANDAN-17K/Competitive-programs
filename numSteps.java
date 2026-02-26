
class Solution {
    public int numSteps(String s) {
        int N = s.length();
        int cry = 0;
        int cnt = 0;
        for(int i = N - 1;i>0;i--){
            int n = Character.getNumericValue(s.charAt(i))+cry;
            if(n % 2 == 1){
                cry = 1;
                cnt += 2;
            }else{
                cnt++;
            }
        }
        return cnt+cry;
    }
}
