class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 1;i<n;i++){
            min = Math.min(arr[i] - arr[i-1],min);
        }
        for(int i = 1;i<n;i++){
            if(arr[i] - arr[i -1] == min){
                res.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return res;
    }
}
