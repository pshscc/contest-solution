
/**
 * @author Shakeel Samsudeen
 */

import java.io.*;
import java.util.*;

public class Solution2 {

    private static char[][] grid;
    private static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        grid = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = in.readLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '.')
                    max = Math.max(floodfill(i, j), max);
            }
        }
        out.println(max);
        out.close();
    }

    private static int floodfill(int r, int c) {
        int[] dr = { -1, 0, 0, 1 };
        int[] dc = { 0, -1, 1, 0 };
        int area = 0;
        Position start = new Position(r, c);
        Stack<Position> stack = new Stack<Position>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Position p = stack.pop();
            for (int i = 0; i < 4; i++) {
                int tr = p.x + dr[i];
                int tc = p.y + dc[i];
                if (!inRange(tr, tc))
                    area += 0;
                else if (visited[tr][tc])
                    area += 0;
                else {
                    visited[tr][tc] = true;
                    if (grid[tr][tc] == '#')
                        area += 0;
                    else {
                        area++;
                        stack.push(new Position(tr, tc));
                    }
                }
            }
        }
        return area;
    }

    private static boolean inRange(int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}