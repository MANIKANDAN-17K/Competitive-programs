class Solution {
    public boolean checkStrings(String s1, String s2) {
        if(s2.length() != s1.length()) return false;
        int[] c1 = new int[256];
        int[] c2 = new int[256];
        for(int i = 0;i<s1.length();i++){
            int offset = (i & 1) << 7;
            c1[offset + s1.charAt(i)]++;
            c2[offset + s2.charAt(i)]++;
        }
        return Arrays.equals(c1,c2);
    }
}
