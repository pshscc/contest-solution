import java.io.*;
import java.math.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("reverse.dat"));
        //System.out.print(Long.MAX_VALUE);
        String[] words;
        int i, vowel;
        String vowelList = "aeiouAEIOU";
        while(in.hasNextLine()){
            words = in.nextLine().split(" ");
            Stack<String> vo = new Stack<String>();
            for(int k = 0; k < words.length; k++){
                if(-1 != vowelList.indexOf(words[k].charAt(0)))
                    vo.push(words[k]);

            }
            for(int j = 0; j < words.length; j++){
                if(-1 != vowelList.indexOf(words[j].charAt(0)))
                    System.out.print(vo.pop() + " ");
                else
                    System.out.print(words[j] + " ");
            }
            System.out.println( );
        }
        /*while(in.hasNextLine()){
            words = in.nextLine().split(" ");
            i = 0;
            vowel = words.length - 1;
            while(i < vowel){
                while(i < words.length - 1 && -1 == vowelList.indexOf(words[i].charAt(0))){
                    i++;
                }
                while(vowel > 0 && -1 == vowelList.indexOf(words[vowel].charAt(0))){
                    vowel--;
                }
                if(vowel <= i)
                    break;
                else{
                    String temp = words[i];
                    words[i] = words[vowel];
                    words[vowel] = temp;
                    i++;
                    vowel--;
                }
            }
            for(String s: words){
                System.out.print(s + " ");
            }
            System.out.println();
        }*/

    }
}
