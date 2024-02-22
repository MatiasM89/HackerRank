package LeetCode.FindTheTownJudge;


public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n + 1];
        int[] isTrusted = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            trusts[trust[i][0]]++;
            isTrusted[trust[i][1]]++;
        }
        for (int j = 1; j <= n; j++) {
            if (trusts[j] == 0 && isTrusted[j] == n - 1)
                return j;
        }
        return -1;
    }

}
