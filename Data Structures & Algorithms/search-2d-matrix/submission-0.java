class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[] arr = new int[m * n];
        int left = 0, right = m * n, mid = 0, idx = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[idx++] = matrix[i][j];
            }
        }

        while(left < right) {
            mid = left + (right - left) / 2;

            if(arr[mid] == target) {
                return true;
            } else if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return false;
    }
}
