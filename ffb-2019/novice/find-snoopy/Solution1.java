import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int max = Integer.MIN_VALUE, r = 0, c = 0;
        for(int i = 0; i < arr.length - 2; i++) {
            for(int j = 0; j < arr.length - 2; j++) {
                int temp = calcHourglass(arr, i, j);
                if(temp > max) {
                    max = temp;
                    r = i;
                    c = j;
                }
            }
        }
        out.println("Sum: " + max + " found at row " + r + " column " + c);
        out.close();
    }
    
    private static int calcHourglass(int[][] arr, int r, int c) {
        int sum = 0;
        sum += arr[r][c] + arr[r][c + 1] + arr[r][c + 2] + arr[r + 1][c + 1] + arr[r + 2][c] + arr[r + 2][c + 1] + arr[r + 2][c + 2];
        return sum;
    }
}