package SalesByMatch;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    public static int sockMerchant(int n, List<Integer> ar) {
        HashMap<Integer, Integer> socks = new HashMap<>();
        int numberOfPairs = 0;
        for (Integer sock : ar) {
            if (socks.containsKey(sock)) {
                socks.put(sock, socks.get(sock) + 1);
            } else {
                socks.put(sock, 1);
            }
        }
        for (Map.Entry<Integer, Integer> map : socks.entrySet()) {
            numberOfPairs += (map.getValue() / 2);
        }
        return numberOfPairs;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
