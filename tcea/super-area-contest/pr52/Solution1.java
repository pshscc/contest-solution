import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("pr52.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String[] input = in.readLine().split(" ");
            String res = "";
            if (input.length == 3) {
                String score = input[0] + input[1];
                String win = input[2];
                switch (score) {
                case "ADIN":
                    if (win.equals("S"))
                        res = "SERVER WINS";
                    else
                        res = "DEUCE";
                    break;
                case "ADOUT":
                    if (win.equals("S"))
                        res = "DEUCE";
                    else
                        res = "RECEIVER WINS";
                    break;
                }
            } else {
                String score = input[0];
                String win = input[1];
                switch (score) {
                case "LOVE-LOVE":
                    if (win.equals("S")) {
                        res = "15-LOVE";
                    } else
                        res = "LOVE-15";
                    break;
                case "LOVE-40":
                    if (win.equals("S")) {
                        res = "15-40";
                    } else
                        res = "RECEIVER WINS";
                    break;
                case "LOVE-30":
                    if (win.equals("S")) {
                        res = "15-30";
                    } else
                        res = "15-40";
                    break;
                case "LOVE-15":
                    if (win.equals("S")) {
                        res = "15-15";
                    } else
                        res = "15-30";
                    break;
                case "15-LOVE":
                    if (win.equals("S")) {
                        res = "30-LOVE";
                    } else
                        res = "15-15";
                    break;
                case "30-LOVE":
                    if (win.equals("S")) {
                        res = "40-LOVE";
                    } else
                        res = "30-15";
                    break;
                case "40-LOVE":
                    if (win.equals("S")) {
                        res = "SERVER WINS";
                    } else
                        res = "40-15";
                case "15-40":
                    if (win.equals("S")) {
                        res = "30-40";
                    } else
                        res = "RECEIVER WINS";
                    break;
                case "30-40":
                    if (win.equals("S")) {
                        res = "DEUCE";
                    } else
                        res = "RECEIVER WINS";
                    break;
                case "15-30":
                    if (win.equals("S")) {
                        res = "30-30";
                    } else
                        res = "15-40";
                    break;
                case "40-15":
                    if (win.equals("S")) {
                        res = "SERVER WINS";
                    } else
                        res = "40-30";
                    break;
                case "40-30":
                    if (win.equals("S")) {
                        res = "SERVER WINS";
                    } else
                        res = "DEUCE";
                    break;
                case "DEUCE":
                    if (win.equals("S")) {
                        res = "AD IN";
                    } else
                        res = "AD OUT";
                    break;
                }
            }
            out.println(res);
        }
        out.close();
    }
}