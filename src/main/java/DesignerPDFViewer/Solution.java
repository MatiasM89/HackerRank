package DesignerPDFViewer;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {


    public static int designerPdfViewer(List<Integer> h, String word) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 97; i < 123; i++){
            map.put(Character.toString(i),h.get(i-97));
        }
        int max = map.get(Character.toString(word.charAt(0)));
        for(int i=1;i<word.length();i++){
            if(map.get(Character.toString(word.charAt(i)))>max){
                max = map.get(Character.toString(word.charAt(i)));
            }
        }
        return max * word.length();
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        System.out.println(Character.toString(97));
        bufferedReader.close();
        bufferedWriter.close();
    }
}
