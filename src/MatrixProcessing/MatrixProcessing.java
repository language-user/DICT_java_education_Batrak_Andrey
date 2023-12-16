package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    static private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double[][] firstMatrix;
        int firstRows;
        int firstCols;
        double[][] resultMatrix;
        int resultRows;
        int resultCols;

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                case 3:
                    System.out.println("Enter size of first matrix:");

                    firstMatrix = getMatrixArray(scanner.nextInt(), scanner.nextInt());
                    firstRows = firstMatrix.length;
                    firstCols = firstMatrix[firstRows - 1].length;

                    System.out.println("Enter size of second matrix:");

                    double[][] secondMatrix = getMatrixArray(scanner.nextInt(), scanner.nextInt());

                    int secondRows = secondMatrix.length;
                    int secondCols = secondMatrix[secondRows - 1].length;

                    if (choice == 1) {
                        resultMatrix = addition(firstMatrix, secondMatrix, firstRows, firstCols, secondRows, secondCols);
                    } else {
                        resultMatrix = multiplication(firstMatrix, secondMatrix, firstRows, firstCols, secondRows, secondCols);
                    }

                    resultRows = resultMatrix.length;
                    resultCols = resultMatrix[resultRows - 1].length;

                    printMatrix(resultMatrix, resultRows, resultCols);
                    break;
                case 2:
                    System.out.println("Enter size of first matrix:");

                    firstMatrix = getMatrixArray(scanner.nextInt(), scanner.nextInt());
                    firstRows = firstMatrix.length;
                    firstCols = firstMatrix[firstRows - 1].length;

                    double mul = scanner.nextDouble();

                    resultMatrix = multiply(firstMatrix, firstRows, firstCols, mul);

                    printMatrix(resultMatrix, firstRows, firstCols);
                    break;
                case 4:
                    printTransposeMenu();
                    int transposeType = scanner.nextInt();

                    System.out.println("Enter size of first matrix:");

                    firstMatrix = getMatrixArray(scanner.nextInt(), scanner.nextInt());
                    firstRows = firstMatrix.length;
                    firstCols = firstMatrix[firstRows - 1].length;

                    resultMatrix = transpose(transposeType, firstMatrix, firstRows, firstCols);
                    resultRows = resultMatrix.length;
                    resultCols = resultMatrix[resultRows - 1].length;

                    printMatrix(resultMatrix, resultRows, resultCols);
                    break;
                case 5:
                case 6:
                    System.out.println("Enter size of first matrix:");

                    firstMatrix = getMatrixArray(scanner.nextInt(), scanner.nextInt());
                    firstRows = firstMatrix.length;
                    firstCols = firstMatrix[firstRows - 1].length;

                    if (firstRows != firstCols) {
                        System.out.println("ERROR");
                    } else {
                        if (choice == 5) {
                            System.out.println(determinant(firstMatrix, firstRows));
                        } else {
                            printMatrix(inversion(firstMatrix, firstRows), firstRows, firstRows);
                        }
                    }
                default:
                    return;
            }
        }
    }

    private static double[][] inversion(double[][] matrix, int rows) {
        double[][] temp = new double[rows][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                temp[i][j] = (i + j) % 2 == 0 ?
                        determinant(stripMatrix(matrix, i, j, rows), rows - 1) :
                        -determinant(stripMatrix(matrix, i, j, rows), rows - 1);
            }
        }

        double d = 1 / determinant(matrix, rows);
        double[][] result = multiply(temp, rows, rows, d);

        return mainTrans(result, rows, rows);
    }

    private static double determinant(double[][] matrix, int rows) {
        double determinant = 0;

        if (rows == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        for (int i = 0; i < rows; i++) {
            double[][] temp = stripMatrix(matrix, 0, i, rows);
            determinant += i % 2 == 0 ? matrix[0][i] * determinant(temp, rows-1) : -(matrix[0][i] * determinant(temp, rows-1));
        }

        return determinant;
    }

    private static double[][] stripMatrix(double[][] matrix, int x, int y, int rows) {
        double[][] result = new double[rows - 1][rows - 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (i != x && j != y) {
                    if (i < x && j < y) {
                        result[i][j] = matrix[i][j];
                    } else if (i < x) {
                        result[i][j - 1] = matrix[i][j];
                    } else if (j < y) {
                        result[i - 1][j] = matrix[i][j];
                    } else {
                        result[i - 1][j - 1] = matrix[i][j];
                    }
                }
            }
        }

        return result;
    }

    private static double[][] multiply(double[][] matrix, int rows, int cols, double mul) {
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mul * matrix[i][j];
            }
        }

        return result;
    }

    private static double[][] multiplication(double[][] fM, double[][] sM, int fR, int fC, int sR, int sC) {
        if (fC != sR) {
            System.out.println("ERROR");

            return new double[][]{{}};
        }

        int height = fR;
        int width = sC;
        double[][] result = new double[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result[i][j] = multiplyRows(fM[i], getCol(sM, j, sR));
            }
        }

        return result;
    }

    private static double multiplyRows(double[] rowA, double[] rowB) {
        double result = 0;

        for (int i = 0; i < rowA.length; i++) {
            result += rowA[i] * rowB[i];
        }

        return result;
    }

    private static double[] getCol(double[][] matrix, int col, int rows) {
        double[] temp = new double[rows];

        for (int i = 0; i < rows; i++) {
            temp[i] = matrix[i][col];
        }

        return temp;
    }

    private static double[][] addition(double[][] fM, double[][] sM, int fR, int fC, int sR, int sC) {
        if (fR != sR || fC != sC) {
            System.out.println("ERROR");

            return new double[][]{{}};
        } else {
            double[][] result = new double[fR][fC];

            for (int i = 0; i < fR; i++) {
                for (int j = 0; j < fC; j++) {
                    result[i][j] = fM[i][j] + sM[i][j];
                }
            }

            return result;
        }
    }

    static void printMatrix(double[][] matrix, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(String.format("%.5f", matrix[i][j]));

                if (j != columns - 1) {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    static void printMenu() {
        System.out.println("1. Add matrices\n" +
                "2. Multiply matrix to a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "5. Calculate a determinant\n" +
                "6. Inverse matrix\n" +
                "0. Exit\n" +
                "Your choice: ");
    }

    static void printTransposeMenu() {
        System.out.println("1. Main diagonal\n" +
                "2. Sub diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n");
    }

    private static double[][] getMatrixArray(int a, int b) {
        double[][] res = new double[a][b];

        System.out.println("Enter matrix:");

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                res[i][j] = scanner.nextDouble();
            }
        }

        return res;
    }

    private static double[][] transpose(int type, double[][] matrix, int rows, int cols) {
        if (type == 1) {
            return mainTrans(matrix, rows, cols);
        } else if (type == 2) {
            return subTrans(matrix, rows, cols);
        } else if (type == 3) {
            return verticalTrans(matrix, rows, cols);
        }

        return horizontTrans(matrix, rows, cols);
    }

    private static double[][] mainTrans(double[][] matrix, int rows, int cols) {
        double[][] result = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    private static double[][] subTrans(double[][] matrix, int rows, int cols) {
        double[][] result = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[rows - 1 - i][cols - 1 - j];
            }
        }

        return result;
    }

    private static double[][] verticalTrans(double[][] matrix, int rows, int cols) {
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][cols - 1 - j];
            }
        }

        return result;
    }

    private static double[][] horizontTrans(double[][] matrix, int rows, int cols) {
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            result[i] = matrix[rows - 1 - i];
        }

        return result;
    }
}