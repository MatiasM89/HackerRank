package DayOfTheProgrammer;

import java.io.*;

class Result {


    public static String dayOfProgrammer(int year) {
        String result;
        if (year < 1918) {
            if (year % 4 == 0) {
                result = "12.09." + year;
            } else {
                result = "13.09." + year;
            }
        } else if (year > 1918) {
            if (year % 400 == 0) {
                result = "12.09." + year;
            } else if (year % 4 == 0 && year % 100 != 0) {
                result = "12.09." + year;
            } else {
                result = "13.09." + year;
            }
        } else {
            result = "26.09." + year;
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
