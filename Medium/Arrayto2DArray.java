import java.util.*;
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        // Create an array to store the frequency of each integer encountered in the input array
        int freq[] = new int[nums.length + 1];

        // Create a list to store the resulting 2D array
        ArrayList<List<Integer>> ans = new ArrayList<>();

        // Iterate through the input array
        for (int c : nums) {
            // If the frequency of the current integer is greater than or equal to the number of rows in the result,
            // add a new row to the result list
            if (freq[c] >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            // Store the integer in the list corresponding to its current frequency.
            ans.get(freq[c]).add(c);

            // Increment the frequency of the current integer
            freq[c]++;
        }

        // Return the resulting 2D array
        return ans;
    }
}
