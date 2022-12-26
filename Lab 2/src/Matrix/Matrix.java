package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix {

    private double[][] cur_matrix;

    private void create_matrix(int i, int j) {
        cur_matrix = new double[i][j];
    }

    public Matrix() {
        create_matrix(0, 0);
    }

    public Matrix(int i, int j) {
        create_matrix(i, j);
    }

    public Matrix(Matrix matrix) {
        cur_matrix = matrix_copy(matrix.cur_matrix);
    }

    public Matrix(double[][] matrix){
        cur_matrix = matrix;
    }

    private double[][] matrix_copy(double[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        double[][] new_matrix = new double[rows][columns];
        for (int i = 0; i<rows; i++){
            new_matrix[i] = Arrays.copyOf(matrix[i], columns);
        }
        return  new_matrix;
    }

    public void add_elements_random (){
        int min = -10;
        int max = 10;
        for (int i = 0; i<cur_matrix.length; i++){
            for (int j = 0; j< cur_matrix[i].length; j++){
                double random_double = Math.floor(Math.random()*(max-min+1)+min);
                cur_matrix[i][j] = random_double;
            }
        }
    }

    public void add_elements (){
        for (int i = 0; i<cur_matrix.length; i++){
            for (int j = 0; j< cur_matrix[i].length; j++){
                Scanner myObj = new Scanner(System.in);
                double new_double = Double.parseDouble(myObj.nextLine());
                cur_matrix[i][j] = new_double;
            }
        }
    }
    public double get_element (int i, int j){
        return cur_matrix[i-1][j-1];
    }

    public double[] get_row(int i){
        return cur_matrix[i-1];
    }

    public double[] get_column(int j){
        double[] column = new double[cur_matrix.length];
        for (int i = 0; i<cur_matrix.length;i++){
            column[i] = cur_matrix[i][j-1];
        }
        return column;
    }

    public int[] get_dimension (){
        int i = cur_matrix.length;
        int j = cur_matrix[0].length;
        return new int[]{i, j};
    }

    @Override
    public boolean equals(Object o) {
        if (cur_matrix == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.deepEquals(cur_matrix, matrix.cur_matrix);
    }

    @Override
    public int hashCode(){
        return Arrays.deepHashCode(cur_matrix);
    }

    public static double[][] matrix_row(int row){
        int min = -20;
        int max = 20;
        double[][] matrix = new double[1][row];
        for (int i = 0;i<1; i++){
            for (int j = 0; j<row; j++){
                double random_double = Math.floor(Math.random()*(max-min+1)+min);
                matrix[i][j] = random_double;
            }
        }
        return matrix;
    }

    public void matrix_multi(Matrix matrix) throws Exception {
        if(cur_matrix[0].length != matrix.cur_matrix.length){
            throw new Exception("Matrix are not compatible");
        }
        double[][] resulting = new double[cur_matrix.length][matrix.cur_matrix[0].length];

        for(int i=0;i<cur_matrix.length;i++){
            for(int j=0;j<matrix.cur_matrix[0].length;j++){
                resulting[i][j]=0;
                for(int k=0;k<cur_matrix[0].length;k++){
                    resulting[i][j]+=cur_matrix[i][k]*matrix.cur_matrix[k][j];
                }
            }
        }
    cur_matrix = resulting;
    }

    public void show(){
        System.out.println("The matrix:");
        for (double[] curMatrix : cur_matrix) {
            for (int j = 0; j < cur_matrix[0].length; j++) {
                System.out.print(curMatrix[j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}