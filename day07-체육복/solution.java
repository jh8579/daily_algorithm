import java.util.*;

class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int n, int[] lost, int[] reserve) {
        for(int i=0; i<= n+1; i++) {
            if(i == 0 || i == n+1) {
                map.put(i, 0);
                continue;
            }
            map.put(i, 1);
        }
        
        for(int i=0; i<reserve.length; i++) {
            map.put(reserve[i], map.get(reserve[i]) + 1);
        }
        
        for(int i=0; i<lost.length; i++) {
            map.put(lost[i], map.get(lost[i]) - 1);
        }

        
        for(int key : map.keySet()) {
            if(key == 0 || key == n+1) {
                continue;
            }
            
            if(map.get(key) <= 0) {
                if(map.get(key - 1) > 1) {
                    map.put(key - 1, map.get(key-1)-1); 
                    map.put(key, 1);
                } else if(map.get(key + 1) > 1) {
                    map.put(key, 1);
                    map.put(key + 1, map.get(key+1)-1); 
                } 
            }
        }
        
        int answer = 0;
        
        for(int key : map.keySet()) {
            if(map.get(key) > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
