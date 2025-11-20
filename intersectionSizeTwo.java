class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b) ->
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );
        int a = -1,b = -1;
        int ans = 0;
        for(int[] i : intervals){
            int l = i[0],r = i[1];

            if(l > b){
                a = r - 1;
                b = r;
                ans += 2;
            }else if ( l > a){
                a = b;
                b = r;
                ans += 1;
            }
        }
        return ans;
    }
}
