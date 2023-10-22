package HackerRankString;

import java.io.*;
import java.util.stream.*;
import java.util.*;

class Result {
    public static String hackerrankInString(String s) {
        List<Character> hacker = new ArrayList<Character>(Arrays.asList('h', 'a', 'c', 'k', 'e', 'r', 'r', 'a', 'n', 'k'));
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==hacker.get(counter)){
                counter++;
            }
            if(counter==hacker.size())
                return "YES";
        }
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.hackerrankInString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
