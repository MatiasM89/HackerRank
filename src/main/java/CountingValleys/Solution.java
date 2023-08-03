package CountingValleys;

import java.io.*;

class Result {


    public static int countingValleys(int steps, String path) {
        int height = 0;
        int valleys = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'D' && height == 0) {
                valleys++;
                height--;
            } else if (path.charAt(i) == 'U') {
                height++;
            } else {
                height--;
            }
        }
        return valleys;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
