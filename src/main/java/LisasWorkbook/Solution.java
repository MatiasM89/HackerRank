package LisasWorkbook;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {
    public static int workbook(int n, int k, List<Integer> arr) {
        int counter = 0;
        int currentPage = 0;
        if(k==1 && arr.size()!=1){
            return 1;
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 1; j <= arr.get(i); j++) {
                if(k==1){
                    counter++;
                    continue;
                }
                if (j % k == 1) {
                    currentPage++;
                }
                if (j == currentPage) {
                    counter++;
                }
            }
        }
        return counter;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
