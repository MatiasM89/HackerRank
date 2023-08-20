package AppendAndDelete;

import java.io.*;

class Result {
    public static String appendAndDelete(String s, String t, int k) {

        //looks terrible but somehow works
        if (k >= (s.length() + t.length())) {
            return "Yes";
        }
        if (s.length() <= t.length()) {
            int i;
            for (i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i))
                    break;
            }
            int numberOfOperations = s.length() - i + t.length() - i;
            if (k >= numberOfOperations && (k - numberOfOperations) % 2 == 0) {
                return "Yes";
            } else {
                return "No";
            }
        } else {
            int i;
            for (i = 0; i < t.length(); i++) {
                if (s.charAt(i) != t.charAt(i))
                    break;
            }
            int numberOfOperations = s.length() - i + t.length() - i;
            if (k >= numberOfOperations && (k - numberOfOperations) % 2 == 0) {
                return "Yes";
            } else {
                return "No";
            }

        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
