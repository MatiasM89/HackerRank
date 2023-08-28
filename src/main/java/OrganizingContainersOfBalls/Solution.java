package OrganizingContainersOfBalls;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {
    public static String organizingContainers(List<List<Integer>> container) {
        ArrayList<Integer> numberOfEachColor = new ArrayList<>();
        ArrayList<Integer> numberOfBallsInContainers = new ArrayList<>();
        for (int i = 0; i < container.size(); i++) {
            numberOfEachColor.add(0);
        }
        for (List<Integer> list : container) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                numberOfEachColor.set(i, numberOfEachColor.get(i) + list.get(i));
                sum += list.get(i);
            }
            numberOfBallsInContainers.add(sum);
        }
        numberOfEachColor.sort(Comparator.reverseOrder());
        numberOfBallsInContainers.sort(Comparator.reverseOrder());
        if (numberOfBallsInContainers.equals(numberOfEachColor)) {
            return "Possible";
        }
        return "Impossible";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

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
