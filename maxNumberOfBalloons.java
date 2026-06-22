class Solution {
    public int maxNumberOfBalloons(String text) {
        int b =0,a=0,l=0,o=0,n=0;
        for(char ch : text.toCharArray()){
            if(ch == 'b') b++;
            if(ch == 'a') a++;
            if(ch == 'l') l++;
            if(ch == 'o') o++;
            if(ch == 'n') n++;
        }
         return Math.min(
            Math.min(b, a),
            Math.min(l / 2, Math.min(o / 2, n))
        );
    }
}
