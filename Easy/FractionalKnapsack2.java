import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort the boxTypes array based on the number of units per box in descending order
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int maxUnits = 0;
        int remainingTruckSize = truckSize;

        for (int i = 0; i < boxTypes.length; i++) {
            int boxesToTake = Math.min(remainingTruckSize, boxTypes[i][0]);
            maxUnits += boxesToTake * boxTypes[i][1];
            remainingTruckSize -= boxesToTake;

            if (remainingTruckSize == 0) {
                break;
            }
        }

        return maxUnits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] boxTypes1 = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize1 = 4;
        System.out.println(solution.maximumUnits(boxTypes1, truckSize1)); // Output: 8

        int[][] boxTypes2 = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize2 = 10;
        System.out.println(solution.maximumUnits(boxTypes2, truckSize2)); // Output: 91
    }
}
