package RepeatedString;

import java.io.*;

class Result {
    public static long repeatedString(String s, long n) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                counter++;
        }
        long div = (long) (n / s.length());
        long result = div * counter;
        long rest = n % s.length();
        for (int i = 0; i < rest; i++) {
            if (s.charAt(i) == 'a') {
                result++;
            }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
