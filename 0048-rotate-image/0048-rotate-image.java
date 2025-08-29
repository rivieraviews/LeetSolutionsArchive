class Solution {

    public static void transpose(int[][] matrix, int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = i+1; j < n; j++)
            {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    public static void reverse(int[][] matrix, int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n/2; j++)
            {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = t;
            }
        }
    }

    public void rotate(int[][] matrix) {
        //transpose + reverse
        
        transpose(matrix, matrix.length);
        reverse(matrix, matrix.length);
    }
}