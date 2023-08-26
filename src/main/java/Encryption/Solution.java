package Encryption;

import java.io.*;
import java.util.ArrayList;

class Result {
    public static String encryption(String s) {
        int length = s.length();
        int lFloor = (int) Math.floor(Math.sqrt(length));
        int lCeiling = (int) Math.ceil(Math.sqrt(length));
        if (lFloor * lCeiling < s.length()) {
            if (lFloor < lCeiling) {
                lFloor++;
            } else {
                lCeiling++;
            }
        }
        ArrayList<String> encryption = new ArrayList<>();
        int currentChar = 0;
        for (int i = 0; i < lFloor; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < lCeiling; j++) {
                if (s.length() - currentChar <= 0) {
                    break;
                }
                builder.append(s.charAt(currentChar));
                currentChar++;
            }
            encryption.add(builder.toString());
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lCeiling; i++) {
            for (int j = 0; j < encryption.size(); j++) {
                if (i >= encryption.get(j).length()) {
                    continue;
                }
                builder.append(encryption.get(j).charAt(i));
            }
            if (i != encryption.get(0).length() - 1) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
