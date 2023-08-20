package ExtraLongFactorials;

import java.io.*;
import java.math.BigInteger;

class Result {
    public static void extraLongFactorials(int n) {
        BigInteger integer = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            integer = integer.multiply(BigInteger.valueOf(i));
        }
        System.out.println(integer);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
