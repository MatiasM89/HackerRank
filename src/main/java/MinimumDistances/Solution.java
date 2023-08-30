package MinimumDistances;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {
    public static int minimumDistances(List<Integer> a) {
        int minimum = -1;
        for (int i = 0; i < a.size(); i++) {
            int current = a.get(i);
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(j) == current) {
                    if (minimum == -1) {
                        minimum = Math.abs(i - j);
                    }
                    if (Math.abs(i - j) < minimum) {
                        minimum = Math.abs(i - j);
                    }

                }
            }
        }
        return minimum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .toList();

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/*
HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            if (map.containsKey(a.get(i))) {
                List<Integer> temp = map.get(i);
                temp.add(i);
                map.put(a.get(i), temp);
            } else {
                map.put(a.get(i), i);
            }
        }

 */
