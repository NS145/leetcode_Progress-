class NumMatrix {

    int[][] prefixSum;

    public NumMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        prefixSum = matrix;

        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                prefixSum[row][col] += prefixSum[row - 1][col];
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                prefixSum[row][col] += prefixSum[row][col - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int res = prefixSum[row2][col2];

        if (row1 != 0)
            res -= prefixSum[row1 - 1][col2];

        if (col1 != 0)
            res -= prefixSum[row2][col1 - 1];

        if (row1 != 0 && col1 != 0)
            res += prefixSum[row1 - 1][col1 - 1];

        return res;
    }
}