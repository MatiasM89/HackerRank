package FindDigits;

import java.io.*;
import java.util.stream.*;

class Result {
    public static int findDigits(int n) {
        int counter = 0;
        String number = Integer.toString(n);
        for (int i = 0; i < number.length(); i++) {
            if (Character.getNumericValue(number.charAt(i)) == 0) {
                continue;
            }
            if (n % Character.getNumericValue(number.charAt(i)) == 0) {
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

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.findDigits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
