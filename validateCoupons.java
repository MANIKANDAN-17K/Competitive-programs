class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("electronics",0);
        map.put("grocery",1);
        map.put("pharmacy",2);
        map.put("restaurant",3);
        List<String[]> valid = new ArrayList<>();
        for(int i = 0;i < code.length;i++){
            if(isActive[i] && map.containsKey(businessLine[i]) && code[i].matches("^[A-Za-z0-9_]+")){
                valid.add(new String[]{code[i],businessLine[i]});
            }
        }
        Collections.sort(valid,(a,b)->{
            int p1 = map.get(a[1]);
            int p2 = map.get(b[1]);

            if(p1 != p2) return p1 - p2;
            return a[0].compareTo(b[0]);
        });

        List<String> ans = new ArrayList<>();
        for(String[] v : valid){
            ans.add(v[0]);
        }
        return ans;   
    }
}
