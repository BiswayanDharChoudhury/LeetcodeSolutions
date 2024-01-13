import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int currentDiff = arr[i] - arr[i - 1];

            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                result.clear();
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (currentDiff == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {4, 2, 1, 3};
        System.out.println(solution.minimumAbsDifference(arr1)); // Output: [[1,2],[2,3],[3,4]]

        int[] arr2 = {1, 3, 6, 10, 15};
        System.out.println(solution.minimumAbsDifference(arr2)); // Output: [[1,3]]

        int[] arr3 = {3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println(solution.minimumAbsDifference(arr3)); // Output: [[-14,-10],[19,23],[23,27]]
    }
}

