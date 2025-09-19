class TaskManager {
    private PriorityQueue<int[]> pd;
    private Map<Integer,Integer> taskPriority;
    private Map<Integer,Integer> ownerTask;
    public TaskManager(List<List<Integer>> tasks) {
        pd = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];  
        });
        taskPriority = new HashMap<>();
        ownerTask = new HashMap<>();
        for(List<Integer> t : tasks){
            add(t.get(0),t.get(1),t.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        pd.add(new int[]{priority,taskId});
        taskPriority.put(taskId,priority);
        ownerTask.put(taskId,userId);    
    }
    
    public void edit(int taskId, int newPriority) {
        pd.add(new int[]{newPriority,taskId});
        taskPriority.put(taskId,newPriority);
    }
    
    public void rmv(int taskId) {
        taskPriority.put(taskId,-1); 
    }
    
    public int execTop() {
        while(!pd.isEmpty()){
            int[] t = pd.poll();
            int p = t[0];
            int id = t[1];
            if(taskPriority.getOrDefault(id,-2) == p){
                taskPriority.put(id,-1);
                return ownerTask.getOrDefault(id,-2);
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
