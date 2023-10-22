package MarsExploration;

import java.io.*;


class Result {
    public static int marsExploration(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 3 == 0 || i % 3 == 2) {
                if (s.charAt(i) != 'S')
                    counter++;
            } else {
                if (s.charAt(i) != 'O')
                    counter++;
            }
        }
        return counter;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
