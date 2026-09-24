import java.util.*;

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int k = queries[q][0];
            int trim = queries[q][1];

            Integer[] indices = new Integer[nums.length];

            for (int i = 0; i < nums.length; i++) {
                indices[i] = i;
            }

            Arrays.sort(indices, (a, b) -> {
                String x = nums[a].substring(nums[a].length() - trim);
                String y = nums[b].substring(nums[b].length() - trim);

                // Compare trimmed numbers
                int cmp = x.compareTo(y);

                // If equal, smaller original index comes first
                if (cmp == 0) {
                    return Integer.compare(a, b);
                }

                return cmp;
            });

            ans[q] = indices[k - 1];
        }

        return ans;
    }
}