class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (arr[curr] == 0) {
                return true;
            }

            if (arr[curr] < 0) {
                continue;
            }

            int jump = arr[curr];

            // Mark visited immediately
            arr[curr] = -arr[curr];

            if (curr + jump < arr.length) {
                queue.offer(curr + jump);
            }

            if (curr - jump >= 0) {
                queue.offer(curr - jump);
            }
        }

        return false;
    }
}