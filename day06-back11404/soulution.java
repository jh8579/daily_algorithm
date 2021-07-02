import java.util.Scanner;

public class Main {
    public static final int INF = 1000000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cityNum = scanner.nextInt();
        int busNum = scanner.nextInt();

        int[][] distance = new int[cityNum + 1][cityNum + 1];

        for(int i=1; i <= cityNum; i++) {
            for(int j=1; j <= cityNum; j++) {
                if(i == j) continue;
                distance[i][j] = INF;
            }
        }

        for (int j = 0; j < busNum; j++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int time = scanner.nextInt();

            distance[a][b] = Math.min(time, distance[a][b]);
        }

        for (int k = 1; k <= cityNum; k++) {
            for (int i = 1; i <= cityNum; i++) {
                for (int j = 1; j <= cityNum; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= cityNum; i++) {
            for(int j=1; j <= cityNum; j++) {
                if(distance[i][j] >= INF) sb.append("0 ");
                else sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}

