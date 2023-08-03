package DrawingBook;

import java.io.*;

class Result {
    public static int pageCount(int n, int p) {
        if (p <= (double) n / 2) {
            return p / 2;
        }
        //special case for last page
        if (n - p == 1 && n % 2 == 0) {
            return 1;
        }
        return (n - p) / 2;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
