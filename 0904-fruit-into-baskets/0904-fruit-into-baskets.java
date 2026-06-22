class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;
        int maxPossible = 0;
        while(right < fruits.length){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0)+1);
            while(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left])-1);
                if(map.get(fruits[left]) == 0) map.remove(fruits[left]);
                left++;
            }
            int currLen = right - left + 1;
            maxPossible = Math.max(maxPossible, currLen);
            right++;
        }
        return maxPossible;
    }
}