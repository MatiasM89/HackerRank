package JumpingOnTheCloudsRV;

import java.io.*;
import java.util.*;

public class Solution {

    static int jumpingOnClouds(int[] c, int k) {
        List<Integer> list = new ArrayList<>();
        int energy = 100;
        for (int i = 0; i < c.length; i++) {
            list.add(c[i]);
        }
        int index = 0;
        while ((index + k) % list.size() != 0) {
            if (list.get((index + k) % list.size()) == 1) {
                energy -= 2;
            }
            energy--;
            index += k;
        }
        if (list.get(0) == 1)
            energy -= 2;
        energy--;
        return energy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}