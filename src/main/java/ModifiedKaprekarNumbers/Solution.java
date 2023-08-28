package ModifiedKaprekarNumbers;

import java.io.*;

class Result {
    public static void kaprekarNumbers(int p, int q) {
        boolean present = false;
        for (long i = p; i <= q; i++) {
            long square = i * i;
            String string = String.valueOf(square);
            if (String.valueOf(square).length() == 1) {
                if (Integer.parseInt(string) == i) {
                    System.out.print(i + " ");
                    present = true;
                }
            } else if (Long.parseLong(string.substring(0, string.length() / 2)) + Long.parseLong(string.substring(string.length() / 2)) == i) {
                System.out.print(i + " ");
                present = true;
            }
        }
        if (!present) {
            System.out.println("INVALID RANGE");
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
