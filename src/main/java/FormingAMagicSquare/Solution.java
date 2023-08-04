package FormingAMagicSquare;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {
    public static int formingMagicSquare(List<List<Integer>> s) {
        List<Integer> costList = new ArrayList<>();
        ArrayList<int[][]> possibleSquares = new ArrayList<>(List.of(
                new int[][]{
                        {8, 1, 6},
                        {3, 5, 7},
                        {4, 9, 2}
                },
                new int[][]{
                        {6, 1, 8},
                        {7, 5, 3},
                        {2, 9, 4}
                },
                new int[][]{
                        {4, 9, 2},
                        {3, 5, 7},
                        {8, 1, 6}
                },
                new int[][]{
                        {2, 9, 4},
                        {7, 5, 3},
                        {6, 1, 8}
                },
                new int[][]{
                        {8, 3, 4},
                        {1, 5, 9},
                        {6, 7, 2}
                },
                new int[][]{
                        {4, 3, 8},
                        {9, 5, 1},
                        {2, 7, 6}
                },
                new int[][]{
                        {6, 7, 2},
                        {1, 5, 9},
                        {8, 3, 4}
                },
                new int[][]{
                        {2, 7, 6},
                        {9, 5, 1},
                        {4, 3, 8}
                }
        ));
        for (int[][] matrix : possibleSquares) {
            int sumOfChanges = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sumOfChanges += (Math.abs(matrix[i][j] - s.get(i).get(j)));
                }
            }
            costList.add(sumOfChanges);
        }
        costList.sort(Comparator.naturalOrder());
        return costList.get(0);
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
