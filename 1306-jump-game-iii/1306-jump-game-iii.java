class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int curr = q.poll();

            if(arr[curr] == 0) return true;
            if(arr[curr] < 0) continue;

            int jump = arr[curr];
            arr[curr] = -arr[curr];

            if(curr + jump < arr.length){
                q.offer(curr + jump);
            }

            if(curr - jump >= 0){
                q.offer(curr - jump);
            }
        }
        return false;
    }
}