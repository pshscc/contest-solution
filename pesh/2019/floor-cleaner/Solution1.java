import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("floor_cleaner.dat"));
        char[][] maze = new char[10][10];
        int row = 0;
        int col = 0;
        for (int r = 0; r < 10; r++) {
            String str = in.nextLine();
            for (int c = 0; c < 10; c++) {
                if (str.charAt(c) == 'B') {
                    row = r; // base row
                    col = c; // base col
                }
                maze[r][c] = str.charAt(c);
            }
        }

        while (in.hasNext()) {
            String str = in.nextLine();
            int c = Character.getNumericValue(str.charAt(1));
            int r = Character.getNumericValue(str.charAt(3));
            maze[r][c] = 'O';
        }

        boolean done = false;
        while (!done) {
            traverse(maze, row, col);
            done = true;
        }

        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (maze[r][c] == '-' || maze[r][c] == 'O')
                    System.out.println("(" + c + "," + r + ")");
            }
        }
    }

    private static boolean outtaBounds(int r, int c) {
        return r < 0 || r > 9 || c < 0 || c > 9;
    }

    private static void traverse(char[][] maize, int r, int c) {
        int row = r;
        int col = c;
        maize[row][col] = '.';
        if (!outtaBounds(row - 1, col) && maize[row - 1][col] == '-')
            traverse(maize, row - 1, col);
        if (!outtaBounds(row, col - 1) && maize[row][col - 1] == '-')
            traverse(maize, row, col - 1);
        if (!outtaBounds(row, col + 1) && maize[row][col + 1] == '-')
            traverse(maize, row, col + 1);
        if (!outtaBounds(row + 1, col) && maize[row + 1][col] == '-')
            traverse(maize, row + 1, col);
    }
}
