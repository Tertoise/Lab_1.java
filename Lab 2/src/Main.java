import Matrix.Matrix;
import Matrix.Matrix_Immutable;

import java.util.Arrays;

public class Main {

    public static void main (String[] args) throws Exception {
        //Matrix A = new Matrix();
        //System.out.println(A.hashCode());
        //System.out.println(A.equals(new double[][] {{1},{2}}));
//       Matrix B = new Matrix(4,5);
       //System.out.println(B.hashCode());
//        System.out.println(Arrays.toString(B.get_dimension()));
//        B.add_elements_random();
//        B.show();
//        Matrix A = new Matrix(5,1);
//        A.add_elements_random();
//        A.show();

        //B.matrix_multi(A);
//        B.show();

//        Matrix C = new Matrix(B);
//        System.out.println(Arrays.toString(C.get_row(1)));
//        System.out.println(Arrays.toString(C.get_column(2)));

        Matrix B = new Matrix(2,2);
        B.add_elements_random();
        Matrix_Immutable I = new Matrix_Immutable(B);
        B.show();
        I.show();
        Matrix C = new Matrix(B);
        C.show();
        B.matrix_multi(C);
        B.show();
        I.show();


    }
}
