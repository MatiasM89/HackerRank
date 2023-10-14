package CaesarCipher;

import java.io.*;


class Result {


    public static String caesarCipher(String s, int k) {
        StringBuilder builder = new StringBuilder();
        k = k % 26;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))) {
                builder.append(s.charAt(i));
                continue;
            }
            if (Character.isLowerCase(s.charAt(i))) {
                char temp = (char) (s.charAt(i) + k);
                if (temp > 122) {
                    temp = (char) (temp % 122 + 96);
                }
                builder.append(temp);
            } else {
                char temp = (char) (s.charAt(i) + k);
                if (temp > 90) {
                    temp = (char) (temp % 90 + 64);
                }
                builder.append(temp);
            }
        }
        return builder.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
