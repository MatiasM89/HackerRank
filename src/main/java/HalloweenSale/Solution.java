package HalloweenSale;

import java.io.*;

class Result {

    public static int howManyGames(int p, int d, int m, int s) {
        int counter = 0;
        int currentPrice = p;
        while (s - currentPrice >= 0) {
            counter++;
            s -= currentPrice;
            if (currentPrice - d <= m) {
                currentPrice = m;
            } else {
                currentPrice -= d;
            }
        }
        return counter;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int p = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        int m = Integer.parseInt(firstMultipleInput[2]);

        int s = Integer.parseInt(firstMultipleInput[3]);

        int answer = Result.howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
