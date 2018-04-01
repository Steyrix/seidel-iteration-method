import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){

        ArrayList<Double> ans;
        int n;
        System.out.println("n = ?");

        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();

        double mat[][] = new double[n][n];
        double b[] = new double[n];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = reader.nextDouble();
            }
        }

        System.out.println("Введите свободные члены: ");
        for(int i = 0; i < n; i++)
            b[i] = reader.nextDouble();



        System.out.println("Матрица: \n");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j]+", ");
            }
        }
        System.out.println("Свободные члены: ");

        for(int i = 0; i < n; i++)
            System.out.print(b[i] + ", ");
        System.out.println("");

        ans = Seidel.calculate(mat, b, n,0.00001);

        int x = 0;
        System.out.println("Ответ: \n");
        for(Double d : ans) {
            System.out.print("x" + x++ + " " + d + ", ");
        }
    }
}
