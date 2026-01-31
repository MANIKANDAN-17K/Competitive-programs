class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0,h = letters.length -1;
        int m,pos = -1;
        while(l <= h){
            m = (l+h)/2;
            if(letters[m] > target){
                pos = m;
                h = m - 1;
            }else{
                l= m+1;
            }
        }
        return pos == - 1 ? letters[0] : letters[pos];
    }
}
