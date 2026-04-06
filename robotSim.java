class Solution{
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> obstacleSet = new HashSet<>();
        for(int[] obstacle : obstacles){
            obstacleSet.add(hashCoordinates(obstacle[0],obstacle[1]));
        }
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int[] currentPosition = {0,0};
        int maxDistanceSquared = 0;
        int currentDirection = 0;

        for(int command : commands){
            if(command == -1){
                currentDirection = (currentDirection + 1) % 4;
                continue;
            }
            if(command == -2){
                currentDirection = (currentDirection +3) % 4;
                continue;
            }
            int[] dir = dirs[currentDirection];
            for(int step = 0;step < command;step++){
                int nextX = currentPosition[0] + dir[0];
                int nextY = currentPosition[1] + dir[1];
                if(obstacleSet.contains(hashCoordinates(nextX,nextY))){
                    break;
                }
                currentPosition[0] = nextX;
                currentPosition[1] = nextY;
            }
            maxDistanceSquared = Math.max(
                maxDistanceSquared,
                (currentPosition[0] * currentPosition[0] ) + (currentPosition[1] * currentPosition[1])    
            );
        }
        return maxDistanceSquared;
    }
    private long hashCoordinates(long x,long y){
        return x + 60013 * y;
    }
}
