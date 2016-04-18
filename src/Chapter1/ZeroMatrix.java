package Chapter1;

import CtCILibrary.AssortedMethods;

public class ZeroMatrix {
	public static void zeroMatrix(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		boolean firstRowHasZero = false;
		boolean firstColumnHasZero = false;
		// check if first column has zero
		for (int i = 0; i < row; i++) {
			if(matrix[i][0] == 0) {
				firstColumnHasZero = true;
				break;
			}
		}
		// check if first row has zero
		for (int j = 0; j < column; j++) {
			if(matrix[0][j] == 0) {
				firstRowHasZero = true;
				break;
			}
		}
		// using first row as replacement for the row array and
		// the first column as replacement for the column array
		for (int i = 1; i < row; i++) {
			for (int j =1; j < column; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		// nullify rows according to first column
		for(int i = 0; i < row; i++) {
			if(matrix[i][0] == 0) {
				for(int j = 0; j < column; j++ ) {
					matrix[i][j] = 0;
				}
			}
		}
		// nullify columns according to first row
		for(int j = 0; j < column; j++) {
			if(matrix[0][j] == 0) {
				for(int i = 0; i < row; i++ ) {
					matrix[i][j] = 0;
				}
			}
		}
		// nullify first row if first row has a zero
		if (firstRowHasZero == true) {
			for (int j = 0; j < column; j++) {
				matrix[0][j] = 0;
			}
		}
		// nullify first column if first column has a zero
		if (firstColumnHasZero == true) {
			for (int i = 0; i < row; i++) {
				matrix[i][0] = 0;
			}
		}
	}
	public static void main(String args[]) {
		int nrows = 10;
		int ncols = 15;
		int[][] matrix = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);		

		AssortedMethods.printMatrix(matrix);
		
		zeroMatrix(matrix);
		
		System.out.println();
		
		AssortedMethods.printMatrix(matrix);
	}
}
/*
 * Space Complexity O(1) , reduce the space complexity from O(N) to O(1)
 * Time Complexity O(MN), M and N are row and column of the input matrix separately 
 */