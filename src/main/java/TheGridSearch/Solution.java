package TheGridSearch;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    //not working fully, passes 11/16 tests, fails if the program encounter double semi correct solutions on one row
    public static String gridSearch(List<String> G, List<String> P) {
        int startIndex;
        int lastIndex;
        boolean good;
        for (int i = 0; i < G.size(); i++) {
            good = true;
            lastIndex = G.get(i).lastIndexOf(P.get(0));
            startIndex = G.get(i).indexOf(P.get(0));
            if (startIndex == -1 || lastIndex == -1) {
                continue;
            }
            for (int j = 1; j < P.size(); j++) {
                i++;
                if (!(lastIndex == G.get(i).lastIndexOf(P.get(j)) && startIndex == G.get(i).indexOf(P.get(j)))) {
                    good = false;
                    break;
                }
            }
            if (good) {
                return "YES";
            }
        }
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int R = Integer.parseInt(firstMultipleInput[0]);

                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G = IntStream.range(0, R).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int r = Integer.parseInt(secondMultipleInput[0]);

                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P = IntStream.range(0, r).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = Result.gridSearch(G, P);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
