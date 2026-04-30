class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, left = 0, right = m * n, mid = 0;

        while(left < right) {
            mid = left + (right - left) / 2;
            int r = mid / n, c = mid % n;

            if(matrix[r][c] == target) {
                return true;
            } else if(matrix[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return false;
    }
}
