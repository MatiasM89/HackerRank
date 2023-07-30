package SolveMeFirst;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out))
        ){
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());

            writer.write(Integer.toString(a+b));
            writer.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
