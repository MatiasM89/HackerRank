package StrongPassword;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result {


    public static int minimumNumber(int n, String password) {
        int counter = 0;
        List<Boolean> cases = Arrays.asList(false, false, false, false);

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                cases.set(0, true);
            }
            if (Character.isLowerCase(password.charAt(i))) {
                cases.set(1, true);
            }
            if (Character.isDigit(password.charAt(i))) {
                cases.set(2, true);
            }
            if (password.charAt(i) == '!' ||
                    password.charAt(i) == '@' ||
                    password.charAt(i) == '#' ||
                    password.charAt(i) == '$' ||
                    password.charAt(i) == '%' ||
                    password.charAt(i) == '^' ||
                    password.charAt(i) == '&' ||
                    password.charAt(i) == '*' ||
                    password.charAt(i) == '(' ||
                    password.charAt(i) == ')' ||
                    password.charAt(i) == '-' ||
                    password.charAt(i) == '+') {
                cases.set(3, true);
            }
        }
        for (Boolean x : cases) {
            if (x)
                counter++;
        }
        return Math.max(6 - n, 4 - counter);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
