class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int low = 0;
        int high = rows * columns-1;
        while(low <= high) {
            int mid = (low + high) / 2;

            if (matrix[mid / columns][mid % columns] == target) {
                return true;
            } else if (matrix[mid / columns][mid % columns] < target) {
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }

        return false;
    }
}
