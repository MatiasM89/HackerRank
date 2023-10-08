package AlmostSorted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {
    public static void almostSorted(List<Integer> arr) {
        List<Integer> staticArr = new ArrayList<>(arr);
        staticArr.sort(Comparator.naturalOrder());
        if (staticArr.equals(arr)) {
            System.out.println("yes");
        }
        int left = -1;
        int right = -1;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                left = i;
                break;
            }
        }
        for (int i = arr.size() - 1; i > 0; i--) {
            if (arr.get(i) < arr.get(i - 1)) {
                right = i;
                break;
            }
        }
        int temp = arr.get(left);
        int temp2 = arr.get(right);
        arr.set(left, temp2);
        arr.set(right, temp);
        if (staticArr.equals(arr)) {
            System.out.println("yes");
            System.out.println("swap " + (left + 1) + " " + (right + 1));
            return;
        }
        arr.set(left, temp);
        arr.set(right, temp2);
        List<Integer> temporaryList = new ArrayList<>();
        temporaryList.addAll(arr.subList(0, left));
        List<Integer> toBeReversed = arr.subList(left, right + 1);
        Collections.reverse(toBeReversed);
        temporaryList.addAll(toBeReversed);
        temporaryList.addAll(arr.subList(right + 1, arr.size()));
        if (staticArr.equals(arr)) {
            System.out.println("yes");
            System.out.println("reverse " + (left + 1) + " " + (right + 1));
            return;
        }
        System.out.println("no");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}
