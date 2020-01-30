
/**
 * @author Jonothan Tung
 */

import java.io.*;
import java.util.*;

public class Solution1 {
    private static int[] tree;
    private static double[] rx;
    private static double[] ry;
    private static double[] w;
    private static double[] h;
    private static double[] cx;
    private static double[] cy;
    private static double[] r;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        tree = new int[N + M + 2];
        rx = new double[N + 2];
        ry = new double[N + 2];
        w = new double[N + 2];
        h = new double[N + 2];
        cx = new double[M];
        cy = new double[M];
        r = new double[M];
        // initializes every node in the tree to point to itself
        for (int i = 0; i < tree.length; i++) {
            tree[i] = i;
        }
        // reads in all of the rectangles
        for (int i = 0; i < N; i++) {
            // ignores rectangles that do not intersect with the field
            double rxTemp = in.nextDouble();
            double ryTemp = in.nextDouble();
            double wTemp = in.nextDouble();
            double hTemp = in.nextDouble();
            if (rectangleCollision(rxTemp, ryTemp, wTemp, hTemp, 0, 0, 1000, 1000)) {
                rx[i] = rxTemp;
                ry[i] = ryTemp;
                w[i] = wTemp;
                h[i] = hTemp;
            }
        }
        // reads in all of the circles
        for (int i = 0; i < M; i++) {
            // ignores circles that do not intersect with the field
            double cxTemp = in.nextDouble();
            double cyTemp = in.nextDouble();
            double rTemp = in.nextDouble();
            if (circleToRectangleCollision(0, 0, 1000, 1000, cxTemp, cyTemp, rTemp)) {
                cx[i] = cxTemp;
                cy[i] = cyTemp;
                r[i] = rTemp;
            }
        }
        // make rectangle connections
        for (int i = 0; i < N; i++) {
            // check if each rectangle intersects with the previously checked rectangles
            for (int j = 0; j < i; j++) {
                if (rectangleCollision(rx[i], ry[i], w[i], h[i], rx[j], ry[j], w[j], h[j])) {
                    union(i, j);
                }
            }
            // check if each rectangle intersects with the walls of the field (which are
            // rectangles of height 1000 and width 0)
            if (rectangleCollision(rx[i], ry[i], w[i], h[i], 0, 0, 0, 1000)) {
                union(i, N + M);
            }
            if (rectangleCollision(rx[i], ry[i], w[i], h[i], 1000, 0, 0, 1000)) {
                union(i, N + M + 1);
            }
        }
        // make circle connections
        for (int i = N; i < M + N; i++) {
            // check if each circle intersects with any of the rectangles
            for (int j = 0; j < N; j++) {
                if (circleToRectangleCollision(rx[j], ry[j], w[j], h[j], cx[i - N], cy[i - N], r[i - N])) {
                    union(i, j);
                }
            }
            // check if each circle intersects with any of the previously checked circles
            for (int j = N; j < i; j++) {
                if (circleCollision(cx[i - N], cy[i - N], r[i - N], cx[j - N], cy[j - N], r[j - N])) {
                    union(i, j);
                }
            }
            // check if each circle intersects with any of the walls of the field (which are
            // rectangles of height 1000 and width 0)
            if (circleToRectangleCollision(0, 0, 0, 1000, cx[i - N], cy[i - N], r[i - N])) {
                union(i, N + M);
            }
            if (circleToRectangleCollision(1000, 0, 0, 1000, cx[i - N], cy[i - N], r[i - N])) {
                union(i, N + M + 1);
            }
        }
        // if the walls of the field are connected, there is no path to the other side
        // of the field
        if (connected(N + M, N + M + 1)) {
            System.out.println("No");
        } else
            System.out.println("Yes");
    }

    // determines if 2 rectanges are connected or not; all the edges have to be
    // "past" eachother
    public static boolean rectangleCollision(double x1, double y1, double w1, double h1, double x2, double y2,
            double w2, double h2) {
        return x1 + w1 >= x2 && x1 <= x2 + w2 && y1 <= y2 + h2 && y2 + h2 >= y1;
    }

    // determines if 2 circles are connected; check if the distance between their
    // centers is less than the sum of their radii
    public static boolean circleCollision(double x1, double y1, double r1, double x2, double y2, double r2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) <= r1 + r2;
    }

    // determines if a circle is connected to a rectangle;
    // http://www.jeffreythompson.org/collision-detection/circle-rect.php
    public static boolean circleToRectangleCollision(double rx, double ry, double w, double h, double cx, double cy,
            double r) {
        // keeps track of the closest edges of the rectangle to the circle
        double closestX = cx;
        double closestY = cy;

        // checks the closest Y edges to the circle; ignored if inbetween because its
        // for sure inside
        if (cy > ry + h)
            closestY = ry + h;
        else if (cy < ry)
            closestY = ry;

        // checks the closest X edges to the circle; ignored if inbetween because its
        // for sure inside
        if (cx > rx + w)
            closestX = rx + w;
        else if (cx < rx)
            closestX = rx;

        // checks if the distance between the circle center and the closest point on the
        // rectangle is less than the radius
        return Math.sqrt(Math.pow(cx - closestX, 2) + Math.pow(cy - closestY, 2)) <= r;
    }

    // finds the root of a tree (with path compression)
    public static int root(int x) {
        while (tree[x] != x) {
            tree[x] = tree[tree[x]];
            x = tree[x];
        }
        return x;
    }

    // connects two trees together
    public static void union(int x, int y) {
        tree[root(x)] = root(y);
    }

    // checks if two shapes are connected
    public static boolean connected(int x, int y) {
        return root(x) == root(y);
    }
}