class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList());
        } 
        for(int[] node : prerequisites){
            int course = node[0];
            int reqCourse = node[1];

            indegree[course]++;
            adj.get(reqCourse).add(course);
        }
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int completed = 0;
        while(!q.isEmpty()){
            int currCourse = q.poll();
            completed++;
            for(int nei : adj.get(currCourse)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }
        return completed == numCourses; 
    }
}