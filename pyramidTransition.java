class Solution {
    int[][] T;
    Set<Long> seen;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        T = new int[7][7];
        for(String a: allowed){
            T[a.charAt(0) - 'A'][a.charAt(1)- 'A'] |= 1 << (a.charAt(2) - 'A');
        }
        seen = new HashSet();
        int N = bottom.length();
        int[][] A = new int[N][N];
        int t = 0;
        for(char c : bottom.toCharArray()){
            A[N-1][t++] = c - 'A';
        }
        return solve(A,0,N-1,0);
    }
    public boolean solve(int[][] A,long R, int N,int i){
        if(N == 1 && i == 1){
            return true;
        }else if(i == N){
            if(seen.contains(R)) return false;
            seen.add(R);
            return solve(A,0,N-1,0);
        }else{
            int w = T[A[N][i]][A[N][i+1]];
            for(int b = 0;b<7;++b) if(((w>>b) & 1) != 0){
                A[N-1][i] = b;
                if(solve(A,R*8+(b+1),N,i+1)) return true;
            }
            return false;
        }
    }
}
