import Matrix.Matrix;

import java.util.Arrays;

public class Main {

    public static void main (String[] args) throws Exception {
        Matrix A = new Matrix();
        System.out.println("a hashcode of array:");
        System.out.println(A.hashCode());
        //System.out.println(A.equals(new double[][] {{1},{2}}));
        System.out.println("-------------");
        Matrix B = new Matrix(4,5);
        System.out.println("Adding elements randomly...");
        B.add_elements_random();
        B.show();
        System.out.println("-------------");
        Matrix C = new Matrix(new double[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}});
        System.out.println("The row");
        System.out.println(Arrays.toString(C.get_row(1)));
        System.out.println("The column");
        System.out.println(Arrays.toString(C.get_column(2)));
        C.matrix_multi(new double[][]{{1, 2}, {3,4},{5,6}});
        C.show();
        System.out.println("-------------");
        Matrix D = new Matrix(1,1);
        System.out.println("Add elements to matrix");
        D.add_elements();
        D.show();
        System.out.println("Matrix-row");
        System.out.println(Arrays.deepToString(Matrix.matrix_row(6)));
    }
}
