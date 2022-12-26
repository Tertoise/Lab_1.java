package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public final class Matrix_Immutable {

    private double[][] cur_matrix;

    private void create_matrix(int i, int j) {
        cur_matrix = new double[i][j];
    }

    public Matrix_Immutable() {
        create_matrix(0, 0);
    }

    public Matrix_Immutable(int i, int j) {
        create_matrix(i, j);
    }

    public Matrix_Immutable(Matrix matrix) {
        create_matrix(matrix.get_dimension()[0],matrix.get_dimension()[1]);
        for(int i=0;i<matrix.get_dimension()[0];i++)
            for(int j=0;j<matrix.get_dimension()[1];j++)
                cur_matrix[i][j] = matrix.get_element(i+1,j+1);
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
        double[] column = new double[cur_matrix[0].length];
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

    public boolean equals(Matrix matrix){
        int[] dimension_1 = get_dimension();
        int[] dimension_2 = matrix.get_dimension();
        if (dimension_1[0] != dimension_2[0] || dimension_1[1] != dimension_2[0])
            return false;
        for (int i = 0; i< dimension_1[0]; i++){
            for (int j = 0; j< dimension_1[1]; j++){
                if(cur_matrix[i][j] != matrix.get_element(i,j))
                    return false;
            }
        }
        return true;
    }

    public void add_element(int i, int j, double element){
        cur_matrix[i-1][j-1] = element;
    }
    @Override
    public boolean equals(Object o) {
        if (cur_matrix == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix_Immutable matrix = (Matrix_Immutable) o;
        return Arrays.deepEquals(cur_matrix, matrix.cur_matrix);
    }

    @Override
    public int hashCode(){
        return Arrays.deepHashCode(cur_matrix);
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
