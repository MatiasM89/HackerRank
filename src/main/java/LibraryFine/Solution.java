package LibraryFine;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Result {
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date dateReturn = format.parse(d1 + "-" + m1 + "-" + y1);
        Date dateDue = format.parse(d2 + "-" + m2 + "-" + y2);

        if (dateReturn.before(dateDue) || dateReturn.compareTo(dateDue) == 0) {
            return 0;
        } else if (dateReturn.after(dateDue) && dateReturn.getMonth() == dateDue.getMonth() && dateReturn.getYear() == dateDue.getYear()) {
            return 15 * (d1 - d2);
        } else if (dateReturn.after(dateDue) && dateReturn.getYear() == dateDue.getYear()) {
            return 500 * (m1 - m2);
        }
        return 10000;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d1 = Integer.parseInt(firstMultipleInput[0]);

        int m1 = Integer.parseInt(firstMultipleInput[1]);

        int y1 = Integer.parseInt(firstMultipleInput[2]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d2 = Integer.parseInt(secondMultipleInput[0]);

        int m2 = Integer.parseInt(secondMultipleInput[1]);

        int y2 = Integer.parseInt(secondMultipleInput[2]);
        try {
            int result = Result.libraryFine(d1, m1, y1, d2, m2, y2);
            bufferedWriter.write(String.valueOf(result));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
