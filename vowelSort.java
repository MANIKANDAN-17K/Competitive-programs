class Solution {
    public String sortVowels(String s) {
    char[] arr = s.toCharArray();
    ArrayList<Character> vow = new ArrayList<>();
    for(char ch : arr){
        if(vowels(ch)){
            vow.add(ch);
        }
    }
    Collections.sort(vow);
    int j =0;
    for(int i = 0;i<arr.length;i++){
        if(vowels(arr[i])){
            arr[i] = vow.get(j++);
        }
    }
    return new String(arr);
    }
    private boolean vowels(char ch){
        return "AEIOUaeiou".indexOf(ch) != -1;
    }

}
