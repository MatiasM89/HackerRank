package SuperReducedString;

import java.io.*;


class Result {


    public static String superReducedString(String s) {
        StringBuilder builder = new StringBuilder(s);
        while (hasDuos(builder)) {
            char prev = builder.charAt(0);
            for (int i = 1; i < builder.length(); i++) {
                if (prev == builder.charAt(i)) {
                    builder.delete(i - 1, i + 1);
                    break;
                }
                prev = builder.charAt(i);
            }
        }
        if (builder.isEmpty()) {
            return "Empty String";
        }
        return builder.toString();
    }

    public static boolean hasDuos(StringBuilder s) {
        String string = s.toString();
        if (string.length() == 0)
            return false;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (prev == s.charAt(i))
                return true;
            prev = s.charAt(i);
        }
        return false;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
