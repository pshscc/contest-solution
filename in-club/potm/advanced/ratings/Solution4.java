
/**
 * @author Travis Dula
 */

import java.io.*;
import java.util.*;

public class Solution4 {
    public static void main(String[] args) throws Exception {
        DataInputStream in = new DataInputStream(System.in);
        int pointer = 0;
        byte[] buff = new byte[8192];
        in.read(buff);
        int n = 0;
        while (buff[pointer] != 32) {
            n = n * 10 + buff[pointer++] - 48;
        }
        int m = buff[++pointer] - 48;
        pointer += 2;
        int t = 0;
        while (buff[pointer] != 10) {
            switch (buff[pointer]) {
            case 48:
                t += 9;
                break;
            case 32:
                break;
            default:
                t += buff[pointer] - 48;
            }
            pointer++;
            if (pointer >= 8192)
                in.read(buff, pointer = 0, 8192);
        }
        System.out.println((int) Math.ceil((n * m - t) / (10.0 - m)));
    }
}