import java.util.*;

class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    
    public int[] solution(int[] lottos, int[] win_nums) {
        map.put(0, 6);
        map.put(1, 6);
        map.put(2, 5);
        map.put(3, 4);
        map.put(4, 3);
        map.put(5, 2);
        map.put(6, 1);
        
        int matchCount = 0;
        int zeroCount = 0;
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i] == 0) {
                zeroCount++;
                continue;
            }
            
            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    matchCount++;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = map.get(matchCount + zeroCount);
        answer[1] = map.get(matchCount);
        
        return answer;
    }
}