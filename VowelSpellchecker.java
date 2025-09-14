class Solution {
    private HashSet<String> per_word;
    private HashMap<String,String> case_word;
    private HashMap<String,String> vow_word;
    public String[] spellchecker(String[] wordlist, String[] queries) {
        per_word = new HashSet<>();
        case_word = new HashMap<>();
        vow_word = new HashMap<>();

        for(String word : wordlist){
            per_word.add(word);

            String lWord = word.toLowerCase();
            case_word.putIfAbsent(lWord,word);

            String vWord = deVowel(lWord);
            vow_word.putIfAbsent(vWord,word);
        }
        String[] ans = new String[queries.length];
        for(int i = 0;i<ans.length;i++){
            ans[i] = solve(queries[i]);
        }    
        return ans;
    }
    private String solve(String word){
        if(per_word.contains(word)){
            return word;
        }
        String query = word.toLowerCase();
        if(case_word.containsKey(query)){
            return case_word.get(query);
        }
        String vow = deVowel(query);
        if(vow_word.containsKey(vow)){
            return vow_word.get(vow);
        }
        return "";
    }
    private String deVowel(String word){
        StringBuilder res = new StringBuilder();
        for(char ch : word.toCharArray()){
            res.append((isVowel(ch)) ? "*" : ch);
        }
        return res.toString();
    }
    private boolean isVowel(char ch){
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}
