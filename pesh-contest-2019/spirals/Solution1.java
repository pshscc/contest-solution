import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[][] arr = new char[n][n];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                arr[i][j] = '-';
            }
        }
        int d = 1;
        int E = 0;
        int S = 1;
        int W = 2;
        int N = 2;
        int x = n/2;
        int y = x;
        arr[x][y] = '*';

        spiraling: {
            while(true) {
                //northeast
                for(int i = 0; i<d; i++) {
                    x++;
                    y++;
                    if(x<0 || x>=n || y<0 || y>=n)
                        break spiraling;
                    arr[x][y] = '*';
                }
                //east
                for(int i = 0; i<E; i++) {
                    x++;
                    if(x<0 || x>=n || y<0 || y>=n)
                        break spiraling;
                    arr[x][y] = '*';
                }
                E+=2;
                //southeast
                for(int i = 0; i<d; i++) {
                    x++;
                    y--;
                    if(x<0 || x>=n || y<0 || y>=n)
                        break spiraling;
                    arr[x][y] = '*';
                }
                //south
                for(int i = 0; i<S; i++) {
                    y--;
                    if(x<0 || x>=n || y<0 || y>=n)
                        break spiraling;
                    arr[x][y] = '*';
                }
                S+=2;
                //southwest
                for(int i = 0; i<d; i++) {
                    x--;
                    y--;
                    if(x<0 || x>=n || y<0 || y>=n)
                        break spiraling;
                    arr[x][y] = '*';
                }
                //west
                for(int i = 0; i<W; i++) {
                    x--;
                    if(x<0 || x>=n || y<0 || y>=n)
                        break spiraling;
                    arr[x][y] = '*';
                }
                W+=2;
                //northwest
                for(int i = 0; i<d; i++) {
                    x--;
                    y++;
                    if(x<0 || x>=n || y<0 || y>=n)
                        break spiraling;
                    arr[x][y] = '*';
                }
                //north
                for(int i = 0; i<N; i++) {
                    y++;
                    if(x<0 || x>=n || y<0 || y>=n)
                        break spiraling;
                    arr[x][y] = '*';
                }
                N+=2;
                d++;
            }
        }
        for(int i = n-1; i>=0; i--) {
            for(int j = 0; j<n; j++) {
                System.out.print(arr[j][i]);
            }
            System.out.println();
        }
    }
}
