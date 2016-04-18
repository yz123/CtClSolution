package Chapter1;

import CtCILibrary.AssortedMethods;

public class RotateMatrix {
	public static int[][] rotateMatrix(int[][] matrix) {
		int layer = matrix.length/2;
		for (int i = 0; i < layer; i++) {
			int offset = matrix.length - i*2 - 1;
			for (int j = 0; j < offset; j++) {
				int temp = matrix[i][i+offset-j];
				matrix[i][i+offset-j] = matrix[i+j][i];
				//System.out.println("("+(i+j)+","+i+")"+"->("+i+","+(i+offset-j)+")");
				matrix[i+j][i] = matrix[i+offset][i+j];
				//System.out.println("("+(i+offset)+","+(i+j)+")"+"->("+(i+j)+","+(i)+")");
				matrix[i+offset][i+j] = matrix[i+offset-j][i+offset];
				//System.out.println("("+(i+offset-j)+","+(i+offset)+")"+"->("+(i+offset)+","+(i+j)+")");
				matrix[i+offset-j][i+offset]= temp;
				//System.out.println();
				//AssortedMethods.printMatrix(matrix);
				//System.out.println();
			}
		}
		return matrix;
		
	}
	public static void main(String args[]) {
		int[][] matrix  = AssortedMethods.randomMatrix(3, 3, 0, 9);
		AssortedMethods.printMatrix(matrix);
		rotateMatrix(matrix);
		System.out.println();
		AssortedMethods.printMatrix(matrix);
	}
}
/*
 * Space Complexity O(1)
 * Time Complexity O(N^2), N is the length of the matrix
 */
