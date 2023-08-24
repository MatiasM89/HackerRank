package ACMICPCTeam;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


    public static List<Integer> acmTeam(List<String> topic) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i <= topic.get(0).length(); i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < topic.size() - 1; i++) {
            for (int it = i + 1; it < topic.size(); it++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < topic.get(i).length(); j++) {
                    if (!(topic.get(i).charAt(j) == '0' && topic.get(it).charAt(j) == '0')) {
                        builder.append('1');
                    } else {
                        builder.append('0');
                    }
                }
                String string = builder.toString();
                int temp = numberOf1(string);
                map.put(temp, map.get(temp) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == 0) {
                iterator.remove();
            }
        }
        result.add(map.lastKey());
        result.add(map.lastEntry().getValue());
        return result;
    }

    private static int numberOf1(String a) {
        int counter = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '1')
                counter++;
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

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

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
