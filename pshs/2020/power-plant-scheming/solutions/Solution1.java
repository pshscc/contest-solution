
/**
 * @author JB Ladera
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1 {
    private static int R, C, count, MAX = 0;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int r = 0; r < R; r++)
            map[r] = sc.nextLine().toCharArray();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == '.') {
                    count = 0;
                    floodfill(r, c);
                    MAX = Math.max(MAX, count);
                }
            }
        }
        System.out.println(MAX);
    }

    private static void floodfill(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { r, c });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (visited[cur[0]][cur[1]])
                continue;
            visited[cur[0]][cur[1]] = true;
            count++;
            for (int x = 0; x < 4; x++) {
                int nr = cur[0] + dx[x];
                int nc = cur[1] + dy[x];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == '#' || visited[nr][nc])
                    continue;
                q.offer(new int[] { nr, nc });
            }
        }
    }
}