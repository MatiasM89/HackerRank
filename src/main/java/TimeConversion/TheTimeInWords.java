import java.io.*;
import java.util.HashMap;

class Result {


    public static String timeInWords(int h, int m) {
        String convertedTime;
        HashMap<Integer, String> hoursToWords = new HashMap<>();
        //initialization
        hoursToWords.put(1, "one");
        hoursToWords.put(2, "two");
        hoursToWords.put(3, "three");
        hoursToWords.put(4, "four");
        hoursToWords.put(5, "five");
        hoursToWords.put(6, "six");
        hoursToWords.put(7, "seven");
        hoursToWords.put(8, "eight");
        hoursToWords.put(9, "nine");
        hoursToWords.put(10, "ten");
        hoursToWords.put(11, "eleven");
        hoursToWords.put(12, "twelve");

        HashMap<Integer, String> minutesToWords = new HashMap<>();
        minutesToWords.put(1, "one");
        minutesToWords.put(2, "two");
        minutesToWords.put(3, "three");
        minutesToWords.put(4, "four");
        minutesToWords.put(5, "five");
        minutesToWords.put(6, "six");
        minutesToWords.put(7, "seven");
        minutesToWords.put(8, "eight");
        minutesToWords.put(9, "nine");
        minutesToWords.put(10, "ten");
        minutesToWords.put(11, "eleven");
        minutesToWords.put(12, "twelve");
        minutesToWords.put(13, "thirteen");
        minutesToWords.put(14, "fourteen");
        minutesToWords.put(15, "quarter");
        minutesToWords.put(16, "sixteen");
        minutesToWords.put(17, "seventeen");
        minutesToWords.put(18, "eighteen");
        minutesToWords.put(19, "nineteen");
        minutesToWords.put(20, "twenty");
        minutesToWords.put(21, "twenty one");
        minutesToWords.put(22, "twenty two");
        minutesToWords.put(23, "twenty three");
        minutesToWords.put(24, "twenty four");
        minutesToWords.put(25, "twenty five");
        minutesToWords.put(26, "twenty six");
        minutesToWords.put(27, "twenty seven");
        minutesToWords.put(28, "twenty eight");
        minutesToWords.put(29, "twenty nine");
        minutesToWords.put(30, "half");

        if (m == 0) {
            convertedTime = hoursToWords.get(h) + " o' clock";
        } else if (m == 15) {
            convertedTime = minutesToWords.get(15) + " past " + hoursToWords.get(h);
        } else if (m == 30) {
            convertedTime = minutesToWords.get(30) + " past " + hoursToWords.get(h);
        } else if (m == 45) {
            convertedTime = minutesToWords.get(15) + " to " + hoursToWords.get(h + 1);
        } else if (m < 30) {
            convertedTime = minutesToWords.get(m) + " minutes past " + hoursToWords.get(h);
        } else {
            convertedTime = minutesToWords.get(60 - m) + " minutes to " + hoursToWords.get(h + 1);
        }

        return convertedTime;
    }

}

public class TheTimeInWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
