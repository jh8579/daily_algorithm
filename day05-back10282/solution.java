package back;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNum = scanner.nextInt();

        for (int i = 0; i < testNum; i++) {
            int totalInfectionNum = 0;
            int totalInfectionTime = 0;

            int totalComNum = scanner.nextInt();
            int dependNum = scanner.nextInt();
            int infectionNum = scanner.nextInt();

//            int[][] map = new int[totalComNum + 1][totalComNum + 1];
            Map<Integer, List<Depend>> map = new HashMap<>();

            int[] distance = new int[totalComNum + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);

            for(int j=1; j<=totalComNum; j++) {
                map.put(j, new ArrayList<>());
            }

            for (int j = 0; j < dependNum; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int time = scanner.nextInt();

                map.get(b).add(new Depend(a, time));
            }

            Queue<Depend> queue = new ArrayDeque<>();
            queue.add(new Depend(infectionNum, 0));
            while (!queue.isEmpty()) {
                Depend poll = queue.poll();
                int curNum = poll.num;
                int time = poll.time;

                if(distance[curNum] > time) {
                    distance[curNum] = time;
                } else {
                    continue;
                }

                List<Depend> depends = map.get(curNum);
                for(Depend depend : depends) {
                    queue.add(new Depend(depend.num, depend.time + time));
                }
            }

            for (int j = 0; j < distance.length; j++) {
                if (distance[j] != Integer.MAX_VALUE) {
                    totalInfectionNum++;

                    if (distance[j] > totalInfectionTime) {
                        totalInfectionTime = distance[j];
                    }
                }
            }

            System.out.println(totalInfectionNum + " " + totalInfectionTime);
        }
    }
}

class Depend {
    int num;
    int time;

    public Depend(int num, int time) {
        this.num = num;
        this.time = time;
    }
}

