class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int course = pre[1];
            int reqCourse = pre[0];

            indegree[course]++;
            graph.get(reqCourse).add(course); 
        }

        int[] res = new int[numCourses];
        int finished = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            res[numCourses - finished - 1] = curr;
            finished++;
            for(int ele : graph.get(curr)){
                indegree[ele]--;

                if(indegree[ele] == 0){
                    q.offer(ele);
                }
            }
        }
        if(numCourses != finished){
            return new int[0];
        }else{
            return res;
        }
    }
}