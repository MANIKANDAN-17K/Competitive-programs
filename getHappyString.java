class Solution {
    public String getHappyString(int n, int k) {
        Stack<String> stringStack = new Stack<>();
        int idx = 0;
        stringStack.push("");
        while(stringStack.size() > 0){
            String currentString = stringStack.pop();
            if(currentString.length() == n){
                idx++;
                if(idx == k){
                    return currentString;
                }
                continue;
            }
            for(char currentChar = 'c';currentChar >= 'a';currentChar--){
                if(currentString.length() == 0 || currentString.charAt(currentString.length() - 1) != currentChar){
                    stringStack.push(currentString+currentChar);
                }
            }
        }
        return "";
        
    }
}
