/*
	Do not edit the given code unless otherwise specified (i.e. the given return null; and return 0; can be removed).
*/

import java.util.ArrayList;

public class ExtraMUtil {

    /**
     * Performs element-wise addition of two matrices of the same shape.
     * @param 1: A double[][] that represents a 2D matrix with shape m*n
     * @param 2: A double[][] that represents a 2D matrix with shape m*n
     * @return an ArrayList of double[] that represents the result 2D matrix with shape m*n.
     */
    public static ArrayList<double[]> matAddition(double[][] m1, double[][] m2) {
		ArrayList<double[]> result = new ArrayList<>();
		for (int i = 0; i < m1.length; i++) {
			double[] row = new double[m1[i].length];
			for (int j = 0; j < m1[i].length; j++) {
				row[j] = m1[i][j] + m2[i][j];
			}
			result.add(row);
		}
		return result;
    }

    /**
     * Performs naive matrix multiplication between two matrices of shape [k][l] and [l][m]
     * @param 1: An ArrayList of an ArrayList of Double that represents a 2D matrix with shape k*p
     * @param 2: An ArrayList of double[] that represents a 2D matrix with shape p*m
     * @return A double[][] that represents the result 2D matrix with shape k*m
     */
    public static double[][] matProduct(ArrayList<ArrayList<Double>> m1, ArrayList<double[]> m2) {
		int k = m1.size();
		int p = m2.size();
		int m = m2.get(0).length;
		double[][] result = new double[k][m];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < m; j++) {
				double sum = 0;
				for (int l = 0; l < p; l++) {
					sum += m1.get(i).get(l) * m2.get(l)[j];
				}
				result[i][j] = sum;
			}
		}
		return result;
    }

    /**
     * Performs element-wise multiplication between two matrices and sums the result.
     * @param 1: A double[][] that represents the first input matrix.
     * @param 2: A double[][] that represents the second input matrix.
     * @return a double[][] that represents the result matrix.
     */
	public static double[][] matElemProduct(double[][] m1, double[][] m2) {
		double[][] result = new double[m1.length][m1[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[i].length; j++) {
				result[i][j] = m1[i][j] * m2[i][j];
			}
		}
		return result;
	}

    /**
     * Sum the elements in a given 2D matrix
     * @param 1: A double[][] that represents the input 2D matrix.
     * @return a double that equals the sum of the elements in the matrix.
     */	
    public static double matSum(double[][] m) {
		double sum = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				sum += m[i][j];
			}
		}
		return sum;
    }

    /**
     * Returns the transpose of a given 2D matrix with a shape of [m][n].
     * @param 1: An ArrayList of ArrayList of Double that represents the input 2D matrix.
     * @return a double[][] that represents the result 2D matrix with shape of n*m
     */
    public static double[][] matTranspose(ArrayList<ArrayList<Double>> m) {
		int rows = m.size();
		int cols = m.get(0).size();
		double[][] result = new double[cols][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[j][i] = m.get(i).get(j);
			}
		}
		return result;
    }

    /**
     * Returns a sub-matrix from a given 2D matrix with the specified range of indices.
     * @param 1: An int that indicates the start row index.
     * @param 2: An int that indicates the end row index.
     * @param 3: An int that indicates the start column index.
     * @param 4: An int that indicates the end column index.
	 * @param 5: A double[][] that represents the input 2D matrix.
     * @return an ArrayList of double[] that represents the sub-matrix with shape (param2 - param1 + 1) * (param4 - param3 + 1)
     */
    public static ArrayList<double[]> subMat(int r_s, int r_e, int c_s, int c_e, double[][] m) {
		ArrayList<double[]> result = new ArrayList<>();
		for (int i = r_s; i <= r_e; i++) {
			double[] row = new double[c_e - c_s + 1];
			for (int j = c_s; j <= c_e; j++) {
				row[j - c_s] = m[i][j];
			}
			result.add(row);
		}
		return result;
    }

    /**
     * Flattens a 3D matrix of shape m by n by p into a vector of size m*n*p
     * @param 1: a double[][][] that represents the input 3D matrix.
     * @return a vector of size m*n*p
     */
    public static double[] matToVec(double[][][] m) {
		int d = m.length;
		int h = m[0].length;
		int w = m[0][0].length;
		double[] result = new double[d * h * w];
		int idx = 0;
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < h; j++) {
				for (int k = 0; k < w; k++) {
					result[idx++] = m[i][j][k];
				}
			}
		}
		return result;
    }

    /**
     * Reorganizes a vector to the desired 3D matrix of shape d by h by w.
     * the size of the input vector must equal to d*h*w.
     * @param 1: A double[] that represents the input vector.
     * @param 2: An int that indicates the depth of the reshaped matrix.
     * @param 3: An int that indicates the row size of the reshaped matrix.
     * @param 4: An int that indicates the column size of the reshaped matrix.
     * @return a 3D array of shape d by h by w
     */
    public static double[][][] vecToMat(double[] input, int d, int h, int w){
		double[][][] result = new double[d][h][w];
		int idx = 0;
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < h; j++) {
				for (int k = 0; k < w; k++) {
					result[i][j][k] = input[idx++];
				}
			}
		}
		return result;
    }

    /**
     * Pretty prints a double type vector with the specified number of significant figures.
     * @param 1: the input vector.
     */
	public static void vecPrint(double[] v) {
        for (int j = 0; j < v.length; j++) {
            System.out.printf("%7.3f", v[j]);
        }
        System.out.println("");
    }

    /**
     * Pretty prints a double type 2D matrix with the specified number of significant figures.
     * @param 1: the input matrix.
     */
	public static void matPrint(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.printf("%7.3f", mat[i][j]);
            }
            System.out.println();
        }
    }
}
