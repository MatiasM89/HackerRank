package PlusMinus;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {


    public static void plusMinus(List<Integer> arr) {
        int pos = 0;
        int neg = 0;
        int zero = 0;
        for (Integer number : arr) {
            if (number > 0) {
                pos++;
            } else if (number < 0) {
                neg++;
            } else {
                zero++;
            }
        }
        System.out.println((double) pos /(pos+neg+zero));
        System.out.println((double) neg /(pos+neg+zero));
        System.out.println((double) zero /(pos+neg+zero));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).toList();

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
