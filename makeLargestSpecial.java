class Solution {
    public String makeLargestSpecial(String s) {
        int cnt = 0;
        List<String> res = new LinkedList<>();
        int j = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '1')
                cnt++;
            else
                cnt--;
            if( cnt == 0){
                res.add('1'+makeLargestSpecial(s.substring(j+1,i))+'0');
                j= i+1;
            }
        }
        Collections.sort(res,Collections.reverseOrder());
        return String.join("",res);
    }
}
