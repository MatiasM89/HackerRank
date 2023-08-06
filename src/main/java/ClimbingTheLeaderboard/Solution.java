package ClimbingTheLeaderboard;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    //This is not an optimal solution
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> places = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Integer x : ranked) {
            map.put(x, null);
        }
        TreeMap<Integer, Integer> mapWithPlayerScore;
        for (Integer x : player) {
            mapWithPlayerScore = map;
            mapWithPlayerScore.put(x, null);
            int place = 1;
            for (Map.Entry<Integer, Integer> it : mapWithPlayerScore.descendingMap().entrySet()) {
                mapWithPlayerScore.put(it.getKey(), place);
                System.out.println(it.getKey() + " " + it.getValue());
                place++;
            }
            places.add(mapWithPlayerScore.get(x));
        }
        return places;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
