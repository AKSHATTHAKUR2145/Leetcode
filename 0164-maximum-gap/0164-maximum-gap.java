class Solution {
    public int maximumGap(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        // Find minimum and maximum
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // All numbers are same
        if (min == max) {
            return 0;
        }

        int n = nums.length;

        // Minimum possible maximum gap
        int gap = (max - min + n - 2) / (n - 1);

        // Number of buckets
        int bucketCount = (max - min) / gap + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        // Initialize buckets
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Put numbers into buckets
        for (int num : nums) {
            int index = (num - min) / gap;

            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
        }

        // Find maximum gap
        int ans = 0;
        int previous = min;

        for (int i = 0; i < bucketCount; i++) {

            // khali
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            ans = Math.max(ans, bucketMin[i] - previous);

            previous = bucketMax[i];
        }

        return ans;
    }
}