package CavityMap;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static List<String> cavityMap(List<String> grid) {
        ArrayList<String> newGrid = new ArrayList<>();
        if (grid.size() <= 2) {
            return grid;
        }
        newGrid.add(grid.get(0));
        for (int i = 1; i < grid.size() - 1; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(grid.get(i).charAt(0));
            for (int j = 1; j < grid.get(i).length() - 1; j++) {
                if (grid.get(i).charAt(j) > grid.get(i).charAt(j - 1) &&
                        grid.get(i).charAt(j) > grid.get(i).charAt(j + 1) &&
                        grid.get(i).charAt(j) > grid.get(i - 1).charAt(j) &&
                        grid.get(i).charAt(j) > grid.get(i + 1).charAt(j)
                ) {
                    builder.append("X");
                } else {
                    builder.append(grid.get(i).charAt(j));
                }
            }
            builder.append(grid.get(i).charAt(grid.get(i).length() - 1));
            newGrid.add(builder.toString());
        }

        newGrid.add(grid.get(grid.size() - 1));

        return newGrid;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
