import java.util.*;

class Location {
    int num;
    int depth;
    
    public Location(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }
}

class Solution {
    Queue<Location> queue = new ArrayDeque<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    public static int max(int n[]) {
        int max = n[0];

        for (int i = 1; i < n.length; i++)
            if (n[i] > max) max = n[i];

        return max;
    }
    
    public int solution(int n, int[][] edge) {
        int[] visited = new int[n+1];
        queue.add(new Location(1, 1));
        
        for(int i=1; i<=n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++) {
            int key = edge[i][0];
            int value = edge[i][1];
            
            map.get(key).add(value);
            map.get(value).add(key);
        }
        
        while(!queue.isEmpty()) {
            Location location = queue.poll();
            int num = location.num;
            int depth = location.depth;
            
            if(visited[num] == 0) {
                visited[num] = depth;
            } else {
                continue;
            }
            
            List<Integer> poss = map.get(num);
            for(int i=0; i<poss.size(); i++) {
                queue.add(new Location(poss.get(i), depth + 1));
            }
        }
        
        int max = max(visited);
        int answer = 0;
        for(int i=1; i<visited.length; i++) {
            if(visited[i] == max) {
                System.out.println(i);
                answer++;
            }
        }
        
        return answer;
    }
}
