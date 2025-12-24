class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int i : apple){
            sum += i;
        }
        Integer[] cap = new Integer[capacity.length];
        for(int i = 0;i<capacity.length;i++){
            cap[i] = capacity[i];
        }
        Arrays.sort(cap,Collections.reverseOrder());
        int need = 0;
        while(sum > 0){
            sum -= cap[need];
            need++;
        }
        return need;
    }
}
