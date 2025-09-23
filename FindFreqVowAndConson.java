class Solution {
    public int maxFreqSum(String s) {
        int[] vowFreq = new int[26];
        int[] conFreq = new int[26];
        for(char ch : s.toCharArray()){
            if("aeiou".contains(Character.toString(ch))){
                vowCounter(ch,vowFreq);
            }else{
                conCounter(ch,conFreq); 
            }
        } 
        int vowMax = Arrays.stream(vowFreq).max().getAsInt();
        int conMax = Arrays.stream(conFreq).max().getAsInt();;
    return vowMax + conMax;
    } 
    private void vowCounter(char ch,int[] vowFreq){
        vowFreq[ch - 'a']++;
    }
    private void conCounter(char ch,int[] conFreq){
        conFreq[ch - 'a']++;
    }
} 
