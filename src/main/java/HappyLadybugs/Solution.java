package HappyLadybugs;

import java.io.*;
import java.util.HashMap;
import java.util.stream.*;

//looks terrible but works
class Result {
    public static String happyLadybugs(String b) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            if (map.containsKey(b.charAt(i))) {
                map.put(b.charAt(i), map.get(b.charAt(i)) + 1);
            } else {
                map.put(b.charAt(i), 1);
            }
        }
        if (map.containsKey('_')) {
            map.remove('_');
            if (map.containsValue(1)) {
                return "NO";
            } else {
                return "YES";
            }
        }
        char current = b.charAt(0);
        int counter = 1;
        for (int i = 1; i < b.length(); i++) {
            if(b.charAt(i)==current){
                counter++;
            }else{
                if(counter<2){
                    return "NO";
                }
                counter=1;
                current=b.charAt(i);
            }
        }
        if(counter<2){
            return "NO";
        }
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

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
