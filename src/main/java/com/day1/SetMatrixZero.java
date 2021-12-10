package com.day1;

/*
Solution 1(Brute Force):
1.Traverse matrix and find out cell which contains zero
2.For each zero cell replace row and column with any other number which is not a part of matrix(say x)
3.Replace x with zero
Time Complexity: O((M+N)*(M+N))
Space Complexity: O(1)

Solution 2(Better):
1.Take two dummy array, arr1(for rows) and arr2(for columns)
2.Initialize both arrays with zeros
3.Traverse matrix and if any zero is found then make corresponding arr1 and arr2 1
4.Replace all columns and rows which has 1 with zero
Time Complexity: O((M*N)+(M*N))
Space Complexity: O((M)+(N))

Solution 3(Optimal):
1.
2.
3.

 */
public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {

    }
}
