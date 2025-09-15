class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] letters = text.split(" ");
        int count = 0;
        int len = brokenLetters.length();
        if(len == 0){
            return letters.length;
        }
        for(String str : letters){
            if(valid(str,brokenLetters)){
                count++;
            }
        }
        return count;
    }
    private boolean valid(String str,String brokenLetter){
        String[] brokLet = brokenLetter.split("");
        for(String st : brokLet){
            if(str.contains(st)){
                return false;
            }
        }
        return true;
    }
}
