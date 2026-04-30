class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n, mid = 0, row = 0, col = 0;

        while(left < right) {
            mid = left + (right - left) / 2;
            row = mid / n;
            col = mid % n;

            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return false;
    }
}
