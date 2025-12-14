class Solution {
    private int count(int idx, int seats, String corridor, Map<Pair<Integer,Integer>, Integer> cache){
        if(idx == corridor.length()){
            return seats == 2 ? 1 : 0;
        }
        if(cache.containsKey(new Pair<>(idx,seats))){
            return cache.get(new Pair<>(idx,seats));
        }
        int result = 0;
        if(seats == 2){
            if(corridor.charAt(idx) == 'S'){
                result = count(idx+1,1,corridor,cache);
            }else{
                result = (count(idx+1,0,corridor,cache)+count(idx+1,2,corridor,cache)) % 1000000007;
            }
        }else{
            if(corridor.charAt(idx) == 'S'){
                result = count(idx+1,seats+1,corridor,cache);
            }else{
                result = count(idx+1,seats,corridor,cache);
            }
        }
        cache.put(new Pair<>(idx,seats),result);
        return result;
    }
    public int numberOfWays(String corridor) {
        Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();
        return count(0,0,corridor, cache);
    }
}
