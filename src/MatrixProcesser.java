public class MatrixProcesser {
    //RU: Вспомогательный класс для приведения матрицы и вектора свободных членов к
    //-- удобному виду для последущего применения итерационного метода Зейделя
    //EN: Auxiliary class for casting matrix and free terms' vector to convenient form
    //-- for using Seidel's iteration method

    public static double[][] processMatrix(double mat[][], int n){
        double out[][] = new double[n][n];
        System.arraycopy(mat,0,out,0,mat.length);

        //RU: Делим каждый элемент матрицы на диагональный элемент
        //EN: Divides every element of a matrix by it's diagonal element
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                out[i][j] /= out[i][i];
            }

            //RU: Заменяем диагональный элемент на ноль
            //EN: Substitute diagonal element with zero
            out[i][i] = 0;
        }

        return out;
    }

    public static double[] processVector(double b[], double mat[][], int n){
        double out[] = new double[n];
        System.arraycopy(b, 0, out, 0, b.length);

        //RU: Делим каждый элемент вектора свободных членов на диагональный элемент матрицы
        //EN: Divide every element of a vector by matrix' diagonal element
        for(int i = 0; i < n; i++)
            out[i] /= mat[i][i];

        return out;
    }
}
