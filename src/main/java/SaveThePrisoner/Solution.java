package SaveThePrisoner;

import java.io.*;
import java.util.stream.*;

class Result {


    public static int saveThePrisoner(int n, int m, int s) {
        int cycles = m / n;
        int rest = m % n;
        int index;
        if (cycles == 0) {
            index = (s + rest - 1);
        } else if (cycles == 1) {
            index = (s + rest - 1 + n);
        } else {
            index = (s + rest - 1);
            for (int i = 0; i < cycles; i++) {
                index += n;
            }
        }
        if (index % n == 0) {
            return n;
        } else {
            return index % n;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int s = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.saveThePrisoner(n, m, s);

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
